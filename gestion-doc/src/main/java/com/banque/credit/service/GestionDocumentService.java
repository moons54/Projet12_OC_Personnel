package com.banque.credit.service;

import com.banque.credit.entities.Bilan;
import com.banque.credit.entities.Resultat;

import java.io.File;

public interface GestionDocumentService {

    public void addDoc(File file,String refDossier);


    public void analyseComptable(Resultat resultat);

    public void ratiosComptable(Bilan bilan);




}
