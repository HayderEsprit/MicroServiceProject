package com.patien.mspatien.Exception;



public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Patient avec l'ID " + id + " non trouvé");
    }
}