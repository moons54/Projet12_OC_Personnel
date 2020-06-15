package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.dao.CreditRepository;
import com.banque.credit.gestioncredit.dao.DecisionRepository;
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

    @Override
    public Decision addDecisionCredit(Decision decision, String siret) {
        Credit credit = new Credit();
        if (decision != null) {

            creditRepository.findCreditBySiretClient(siret);

         //   decision.setCredit(credit);

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

      //      decision.setCredit(credit);

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
        return decisionRepository.save(decision);
    }

    @Override
    public Decision saveDecision(Decision decision) {
        Edition edition =new Edition();
        edition.setStatuts("en attente d'edition");
        decision.setEdition(edition);
        return decisionRepository.save(decision);
    }
}
