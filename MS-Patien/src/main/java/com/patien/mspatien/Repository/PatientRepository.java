package com.patien.mspatien.Repository;

import com.patien.mspatien.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}