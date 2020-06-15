package com.banque.credit.gestioncredit.controller;

import com.banque.credit.gestioncredit.dao.DecisionRepository;
import com.banque.credit.gestioncredit.entities.Decision;
import com.banque.credit.gestioncredit.service.DecisionCreditService;
import com.banque.credit.gestioncredit.service.DecisionCreditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DecisionController {

    @Autowired
    DecisionRepository decisionRepository;

    @Autowired
    DecisionCreditServiceImpl decisionCreditService;

    @GetMapping("/decisions")
    public List<Decision> afficheDecision() {
        return decisionRepository.findAll();
    }

    @PutMapping("decision/update")
    public Decision update(@RequestBody Decision decision) {
        return decisionCreditService.updateDecision(decision);
    }


    @GetMapping("/decisions/{id}")
    public Optional<Decision> afficheDecisionById(@PathVariable long id) {
        return decisionRepository.findById(id);
    }

    @PostMapping("/decision/new")
    public Decision save(@RequestBody Decision decision) {
        return decisionCreditService.saveDecision(decision);
    }

}
