package com.banque.credit.service;

import com.banque.credit.entities.Bilan;
import org.apache.pdfbox.pdmodel.PDPage;

public interface GestionBilanService {

    public Bilan addBilan(PDPage pdPage,String refdossier);

    public Bilan findbysiret(String kbis);
}
