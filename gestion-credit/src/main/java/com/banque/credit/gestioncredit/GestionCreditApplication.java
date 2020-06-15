package com.banque.credit.gestioncredit;

import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.entities.Decision;
import com.banque.credit.gestioncredit.entities.Edition;
import com.banque.credit.gestioncredit.service.DecisionCreditService;
import com.banque.credit.gestioncredit.service.EditionCreditService;
import com.banque.credit.gestioncredit.service.GestionCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication

public class GestionCreditApplication {

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(GestionCreditApplication.class, args);
    }



    @Bean
    CommandLineRunner start(GestionCreditService gestionCreditService, DecisionCreditService decisionCreditService,
                            EditionCreditService editionCreditService){
        return args -> {
            System.out.println("ok");

            repositoryRestConfiguration.exposeIdsFor(Credit.class, Decision.class, Edition.class);

          //  List<Credit> credits = gestionCreditService.loadCreditbyObjet("Creation");

          /*  for (Credit credit:credits
                 ) {
                System.out.println(credit.getNature() + credit.getObjet() + credit.getAssurance());
            }
*/
         //   List<Edition> editionList= editionCreditService.editionsdesOffres("Dossier imprimé");


           // Decision decision = new Decision();


          };

        
    }
}


