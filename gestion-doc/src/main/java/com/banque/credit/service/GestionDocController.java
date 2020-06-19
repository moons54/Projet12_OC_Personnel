package com.banque.credit.service;

import com.banque.credit.Dao.BilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class GestionDocController {

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;


    @Autowired
    BilanRepository bilanRepository;


    @PostMapping(path = "/upload/{siret}")
    public void uploadDocument(MultipartFile file, @PathVariable String siret) throws Exception {
        Files.write(Paths.get(System.getProperty("user.home")+"/Documents/projet12_oc_Personnel/gestion-doc/src/main/resources/document/"+siret+".pdf"),file.getBytes());

    }



}
