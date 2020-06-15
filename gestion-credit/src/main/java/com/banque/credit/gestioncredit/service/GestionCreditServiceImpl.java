package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.dao.CreditRepository;
import com.banque.credit.gestioncredit.dao.DecisionRepository;
import com.banque.credit.gestioncredit.dao.EditionRepository;
import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.entities.Decision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GestionCreditServiceImpl implements GestionCreditService {

    @Autowired
    CreditRepository creditRepository;

    @Autowired
    DecisionRepository decisionRepository;

    @Autowired
    EditionRepository editionRepository;

    @Override
    public List<Credit> loadCreditbyObjet(String objetpret) {
        return creditRepository.findCreditByObjet(objetpret);
    }

    @Override
    public Credit save(Credit credit) {
       Decision decision= new Decision();
       decision.setStatuts("en attente");

       decisionRepository.save(decision);
       credit.setDecision(decision);

        return creditRepository.save(credit);
    }

    @Override
    public Credit removecredit(Credit credit) {
        return null;
    }

    @Override
    public Credit updatecredit(Credit credit) {
        return null;
    }

    @Override
    public Credit suppression(long id) {
        return creditRepository.deleteById(id);
    }
}
