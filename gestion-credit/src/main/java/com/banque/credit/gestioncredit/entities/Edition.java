package com.banque.credit.gestioncredit.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Edition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateEdition;
    private String dateDeblocage;
    private String statuts;
    private String commentaire;

}
