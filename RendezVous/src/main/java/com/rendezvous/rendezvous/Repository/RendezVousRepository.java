package com.rendezvous.rendezvous.Repository;


import com.rendezvous.rendezvous.Entity.RendezVous;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends MongoRepository<RendezVous, String> {
    List<RendezVous> findByPatientId(Long patientId);
}