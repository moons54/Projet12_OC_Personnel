package com.banque.credit.gestioncredit.controller;

import com.banque.credit.gestioncredit.dao.EditionRepository;
import com.banque.credit.gestioncredit.entities.Edition;
import com.banque.credit.gestioncredit.service.EditionCreditService;
import com.banque.credit.gestioncredit.service.EditionCreditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class EditionController {

    @Autowired
    EditionCreditServiceImpl editionCreditService;

    @Autowired
    EditionRepository editionRepository;

    @GetMapping("editions")
    public List<Edition> afficheEdition() {
        return editionRepository.findAll();
    }

    @GetMapping("/editions/{id}")
    public Optional<Edition> afficheById(@PathVariable long id) {
        return editionRepository.findById(id);
    }

    @PostMapping("/edition/new")
    public Edition save(@RequestBody Edition edition) {
        return editionRepository.save(edition);
    }
}
