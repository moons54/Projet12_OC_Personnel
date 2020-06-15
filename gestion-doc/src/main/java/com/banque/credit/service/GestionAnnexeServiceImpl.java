package com.banque.credit.service;

import com.banque.credit.Dao.AnnexeRepository;
import com.banque.credit.entities.Annexe;
import com.banque.credit.entities.Participation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class GestionAnnexeServiceImpl implements GestionAnnexeService{


    @Autowired
    AnnexeRepository annexeRepository;

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;

    @Autowired
    GestionParticipationServiceImpl gestionParticipationService;


    public Annexe addAnnexe(PDPage pdPage) {
        try {

            PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

            //CREATION DES ZONES DE TEXTES A RECCUPPER AVEC LIBELLES CORRESPONDANT
            pdfTextStripperByArea.addRegion("siret", DocumentParam.SIRETANNEX);
            pdfTextStripperByArea.addRegion("participant", DocumentParam.NOMBREPARTICIPANT);
            pdfTextStripperByArea.addRegion("nombrepage", DocumentParam.NOMBREPAGE);
            pdfTextStripperByArea.addRegion("numeropage", DocumentParam.NUMEROPAGE);

            pdfTextStripperByArea.addRegion("titre1", DocumentParam.TITRE1);
            pdfTextStripperByArea.addRegion("nom1", DocumentParam.NOM1);
            pdfTextStripperByArea.addRegion("prenom1", DocumentParam.PRENOM1);
            pdfTextStripperByArea.addRegion("nommarital1", DocumentParam.NOMMARITAL1);
            pdfTextStripperByArea.addRegion("participation1", DocumentParam.PARTICIPATION1);
            pdfTextStripperByArea.addRegion("nombrepart1", DocumentParam.NOMBREPART1);
            pdfTextStripperByArea.addRegion("departement1", DocumentParam.DEPARTEMENT1);
            pdfTextStripperByArea.addRegion("commune1", DocumentParam.COMMUNE1);
            pdfTextStripperByArea.addRegion("titre2", DocumentParam.TITRE2);
            pdfTextStripperByArea.addRegion("nom2", DocumentParam.NOM2);
            pdfTextStripperByArea.addRegion("prenom2", DocumentParam.PRENOM2);
            pdfTextStripperByArea.addRegion("nommarital2", DocumentParam.NOMMARITAL2);
            pdfTextStripperByArea.addRegion("participation2", DocumentParam.PARTICIPATION2);
            pdfTextStripperByArea.addRegion("nombrepart2", DocumentParam.NOMBREPART2);
            pdfTextStripperByArea.addRegion("departement2", DocumentParam.DEPARTEMENT2);
            pdfTextStripperByArea.addRegion("commune2", DocumentParam.COMMUNE2);


            pdfTextStripperByArea.extractRegions(pdPage);


            Map<String, String> docannexe = new HashMap<>();

            //Reformatage du texte
            for (int j = 0; j < pdfTextStripperByArea.getRegions().size(); j++) {

                String libelle = gestionDocumentService.converterdoc(pdfTextStripperByArea.getRegions().get(j));
                String valeur = gestionDocumentService.converterdoc(pdfTextStripperByArea.getTextForRegion(pdfTextStripperByArea.getRegions().get(j)));
                docannexe.put(libelle, valeur);
            }

            //CREATION OBJET ANNEXE

            Annexe annexe = new Annexe();
            annexe.setSiret(docannexe.get("siret"));
            annexe.setNombreParticipant(docannexe.get("participant"));
            annexe.setNombrePage(docannexe.get("nombrepage"));
            annexe.setNumeropage(docannexe.get("numeropage"));

            Annexe annexe1 = annexeRepository.findBySiret(annexe.getSiret());

            if (annexe1 != null) {


                Participation participation=gestionParticipationService.addparticipation(pdPage);
               addParticipationToAnnexe(annexe1,participation);
               annexeRepository.save(annexe1);
               return annexe1;
            }
            else {

                Participation participation=gestionParticipationService.addparticipation(pdPage);
              System.out.println("liste participation"+participation.getNom1());
                System.out.println("liste annexe"+annexe.getSiret());
                              addParticipationToAnnexe(annexe,participation);
                return annexeRepository.save(annexe);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Annexe addParticipationToAnnexe(Annexe annexe,Participation participation){
        annexe.getParticipations().add(participation);
    return annexe;
    }

}
