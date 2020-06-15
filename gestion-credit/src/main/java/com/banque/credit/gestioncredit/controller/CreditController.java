package com.banque.credit.gestioncredit.controller;

import com.banque.credit.gestioncredit.dao.CreditRepository;
import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.service.GestionCreditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CreditController {


    @Autowired
    GestionCreditServiceImpl gestionCreditService;

    @Autowired
    CreditRepository creditRepository;

    @GetMapping("/credits")
    public List<Credit> affichecredit() {
        return creditRepository.findAll();
    }

    @GetMapping("/credits/{id}")
    public Optional<Credit> affichebyid(@PathVariable long id) {
        return creditRepository.findById(id);
    }

    @GetMapping("/credit/{reference}")
    public Credit affichebyreference(@PathVariable String reference) {
        return creditRepository.findCreditByReferenceDossier(reference);
    }


    @PutMapping("/credit/new")
    public Credit save(@RequestBody Credit credit){
        return creditRepository.save(credit);
    }

    @DeleteMapping("/credit/{id}")
    public Credit delete(@PathVariable long id) {
        return gestionCreditService.suppression(id);
    }

    @PostMapping("/credit/new")
    public Credit saveone(@RequestBody Credit credit){
        return gestionCreditService.save(credit);
    }


}
