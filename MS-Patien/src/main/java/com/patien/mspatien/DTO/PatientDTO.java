package com.patien.mspatien.DTO;

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