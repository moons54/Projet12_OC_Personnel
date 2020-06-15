package com.banque.credit.service;

import com.banque.credit.Dao.BilanRepository;
import com.banque.credit.entities.Bilan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BilanControler {


    @Autowired
    GestionBilanServiceImpl gestionBilanService;

    @Autowired
    BilanRepository bilanRepository;

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;


    @GetMapping("/bilan/{kbis}")
    public Bilan detailbilan(@PathVariable String kbis){
        return gestionBilanService.findbysiret(kbis);
    }

    @GetMapping("/bilans")
    public List<Bilan> afficheBilan() {
        return bilanRepository.findAll();
    }
}
