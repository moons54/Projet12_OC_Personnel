package com.banque.credit.service;

import com.banque.credit.entities.Participation;
import org.apache.pdfbox.pdmodel.PDPage;

public interface GestionParticipationService {

    public Participation addparticipation(PDPage pdPage);
}
