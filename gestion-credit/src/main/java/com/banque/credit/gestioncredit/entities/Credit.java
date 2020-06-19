package com.banque.credit.gestioncredit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Credit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private String nature;
    private String objet;
    private String duree;
    private String assurance;
    private String referenceDossier;
    private String taux;
    private String echeanceEmprunt;
    private String status;
    private String siretClient;
    private String montant;
    private String coutGlobal;
   // private long user;


    @OneToOne
    private Decision decision;

}
