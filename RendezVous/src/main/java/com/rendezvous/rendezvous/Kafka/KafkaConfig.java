package com.rendezvous.rendezvous.Kafka;

import com.rendezvous.rendezvous.DTO.RendezVousEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class   KafkaConfig {

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // Important: on ne met PAS ici les classes de désérialisation, car elles seront configurées dans les factories spécifiques
        return props;
    }

    // ConsumerFactory pour String messages (texte simple)
    @Bean
    public ConsumerFactory<String, String> textConsumerFactory() {
        Map<String, Object> props = new HashMap<>(consumerConfigs());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> textKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(textConsumerFactory());
        return factory;
    }

    // ConsumerFactory pour objets JSON
    @Bean
    public ConsumerFactory<String, RendezVousEvent> objectConsumerFactory() {
        Map<String, Object> props = new HashMap<>(consumerConfigs());

        // On configure ErrorHandlingDeserializer pour la clé et la valeur
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);

        // Le vrai désérialiseur pour la clé (String)
        props.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);

        // Le vrai désérialiseur pour la valeur (JSON vers RendezVousEvent)
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);

        // Indique la classe cible pour JsonDeserializer
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.rendezvous.rendezvous.DTO.RendezVousEvent");

        // Pour accepter tous les packages
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        // Pour éviter d’attendre le header type dans le message
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RendezVousEvent> objectKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RendezVousEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(objectConsumerFactory());
        return factory;
    }
}
