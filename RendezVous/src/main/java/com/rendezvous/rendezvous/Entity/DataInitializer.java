package com.rendezvous.rendezvous.Entity;

import com.rendezvous.rendezvous.Repository.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(RendezVousRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                RendezVous rdv = new RendezVous();
                rdv.setPatientId(123L);
                rdv.setDateRdv(LocalDateTime.now().plusDays(1));
                rdv.setDescription("Consultation initiale");
                repository.save(rdv);
            }
        };
    }
}