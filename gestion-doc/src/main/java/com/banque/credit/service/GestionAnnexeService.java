package com.banque.credit.service;

import com.banque.credit.entities.Annexe;
import org.apache.pdfbox.pdmodel.PDPage;

public interface GestionAnnexeService {

    public Annexe addAnnexe(PDPage pdPage);
}
