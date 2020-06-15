package com.banque.credit.service;

import com.banque.credit.entities.Resultat;
import org.apache.pdfbox.pdmodel.PDPage;

public interface GestionResultatService {

    public Resultat addExercice(PDPage pdPage, String refDossier);
}
