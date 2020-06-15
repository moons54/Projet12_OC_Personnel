package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.entities.Edition;

import java.util.List;

public interface EditionCreditService {

    public List<Edition> editionsdesOffres(String type);

    public Edition addEditionCredit(Edition edition);

    public Edition removeEdition(Edition edition);

    public Edition changementStatutEdition(Edition edition);

}
