package com.rendezvous.rendezvous.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PatientDTO {
    private String id;
    private String nom;
    private String prenom;
    private String email;
}