package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.dao.CreditRepository;
import com.banque.credit.gestioncredit.dao.DecisionRepository;
import com.banque.credit.gestioncredit.dao.EditionRepository;
import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.entities.Decision;
import com.banque.credit.gestioncredit.entities.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Service
public class DecisionCreditServiceImpl implements DecisionCreditService {

    @Autowired
    DecisionRepository decisionRepository;

    @Autowired
    CreditRepository creditRepository;

    @Autowired
    EditionRepository editionRepository;

    @Override
    public Decision addDecisionCredit(Decision decision, String siret) {
        Credit credit = new Credit();
        if (decision != null) {
            creditRepository.findCreditBySiretClient(siret);
            decisionRepository.save(decision);
        }

        return null;
    }

    @Override
    public Decision removeDecionCredit(Decision decision) {
        return null;
    }

    @Override
    public Decision updateDecisionCredit(Decision decision, String siret) {
        Credit credit = new Credit();
        if (decision != null) {
            creditRepository.findCreditBySiretClient(siret);
            decisionRepository.save(decision);
        }
        return null;
    }

    @Override
    public Decision findAllDecision(Long id) {
        decisionRepository.findAllById(id);

        return null;
    }

    @Override
    public Decision updateDecision(Decision decision) {
        if (decision.getStatuts().contains("accepté" )) {
            Edition edition = new Edition();
            edition.setStatuts("en attente d'edition");
            editionRepository.save(edition);
            decision.setEdition(edition);
            return decisionRepository.save(decision);
        } else {
            System.out.println("la    "+ decision.getStatuts());
            return decisionRepository.save(decision);
        }
    }

    @Override
    public Decision saveDecision(Decision decision) {
        Edition edition =new Edition();
        edition.setStatuts("en attente d'edition");
        decision.setEdition(edition);
        return decisionRepository.save(decision);
    }
}
