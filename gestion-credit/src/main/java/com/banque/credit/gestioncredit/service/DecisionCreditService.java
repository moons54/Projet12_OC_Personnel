package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.entities.Decision;

public interface DecisionCreditService {

    public Decision addDecisionCredit(Decision decision,String siret);

    public Decision removeDecionCredit(Decision decision);

    public Decision updateDecisionCredit(Decision decision,String siret);

    public Decision findAllDecision(Long id);

    public Decision saveDecision(Decision decision);

    public Decision updateDecision(Decision decision);


}
