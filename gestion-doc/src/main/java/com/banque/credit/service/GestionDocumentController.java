package com.banque.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@CrossOrigin("*")
public class GestionDocumentController {

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;

    @Autowired
    GestionBilanServiceImpl gestionBilanService;


    @GetMapping("/analysedoc/{refdossier}")
    public Boolean analyseDocument(@PathVariable String refdossier) {
        File file = new File("/Users/aurelienmimouni/Documents/projet12_oc_Personnel/gestion-doc/src/main/resources/document/"+refdossier+".pdf");
       gestionDocumentService.addDoc(file,refdossier);
       return true;
    }
}
