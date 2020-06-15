package com.banque.credit;

import com.banque.credit.Dao.*;
import com.banque.credit.entities.*;
import com.banque.credit.service.GestionDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.io.File;

@SpringBootApplication
public class CreditWebApplication {
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CreditWebApplication.class, args);

    }
    @Bean
    CommandLineRunner start(SoldeIntermediaireGestionRepository soldeIntermediaireGestionRepository, RatiosRepository ratiosRepository,
                            BilanRepository bilanRepository, ParticipationRepository participationRepository,
                            AnnexeRepository annexeRepository, ResultatRepository resultatRepository,
                            GestionDocumentService gestionDocumentService){
        return args -> {

             repositoryRestConfiguration.exposeIdsFor(Bilan.class, Resultat.class, Annexe.class, Ratios.class, SoldeIntermediaireGestion.class,
                     Participation.class);


            participationRepository.deleteAll();
            annexeRepository.deleteAll();
            resultatRepository.deleteAll();
            bilanRepository.deleteAll();
            soldeIntermediaireGestionRepository.deleteAll();
            ratiosRepository.deleteAll();

        //premier bilan test
           File file = new File("/Users/aurelienmimouni/Downloads/gestion-doc/src/main/resources/document/Pro543255Tr.pdf");
            String ref = "Pro456531Tr";
            gestionDocumentService.addDoc(file,ref);
        //    File file1 = new File("/Users/aurelienmimouni/Downloads/gestion-doc/src/main/resources/document/liasse2all.pdf");

         //   gestionDocumentService.addDoc(file1);

        };
    }
}
