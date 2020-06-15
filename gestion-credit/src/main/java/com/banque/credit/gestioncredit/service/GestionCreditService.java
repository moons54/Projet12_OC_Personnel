package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.entities.Credit;

import java.util.List;

public interface GestionCreditService {

    public List<Credit> loadCreditbyObjet(String objetpret);

    public Credit save(Credit credit);

    public Credit removecredit(Credit credit);

    public Credit updatecredit(Credit credit);

    public Credit suppression(long id);




}
