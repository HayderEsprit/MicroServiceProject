package com.rendezvous.rendezvous.Exception;

public class RendezVousNotFoundException extends RuntimeException {
    public RendezVousNotFoundException(String id) {
        super("Rendez-vous avec l'ID " + id + " non trouvé");
    }
}