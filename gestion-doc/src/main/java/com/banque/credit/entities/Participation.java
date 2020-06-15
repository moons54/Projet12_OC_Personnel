package com.banque.credit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Participation {



    @Id
    private String id;

    private String siret;

    private String titre1;
    private String nom1;
    private String prenom1;
    private String nommarital1;
    private String participation1;
    private String nombrepart1;
    private String departement1;
    private String commune1;

    private String titre2;
    private String nom2;
    private String prenom2;
    private String nommarital2;
    private String participation2;
    private String nombrepart2;
    private String departement2;
    private String commune2;

    @DBRef
    private Annexe annexe;

}
