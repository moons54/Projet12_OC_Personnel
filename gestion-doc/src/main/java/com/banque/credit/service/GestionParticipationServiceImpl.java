package com.banque.credit.service;

import com.banque.credit.Dao.ParticipationRepository;
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
public class GestionParticipationServiceImpl implements GestionParticipationService {

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;




    @Override
    public Participation addparticipation(PDPage pdPage) {
        try {

            PDFTextStripperByArea pdfTextStripperByArea=new PDFTextStripperByArea();

            //CREATION DES ZONES DE TEXTES A RECCUPPER AVEC LIBELLES CORRESPONDANT
            pdfTextStripperByArea.addRegion("siret",DocumentParam.SIRETANNEX);
            pdfTextStripperByArea.addRegion("participant",DocumentParam.NOMBREPARTICIPANT);

            pdfTextStripperByArea.addRegion("titre1",DocumentParam.TITRE1);
            pdfTextStripperByArea.addRegion("nom1",DocumentParam.NOM1);
            pdfTextStripperByArea.addRegion("prenom1",DocumentParam.PRENOM1);
            pdfTextStripperByArea.addRegion("nommarital1",DocumentParam.NOMMARITAL1);
            pdfTextStripperByArea.addRegion("participation1",DocumentParam.PARTICIPATION1);
            pdfTextStripperByArea.addRegion("nombrepart1",DocumentParam.NOMBREPART1);
            pdfTextStripperByArea.addRegion("departement1",DocumentParam.DEPARTEMENT1);
            pdfTextStripperByArea.addRegion("commune1",DocumentParam.COMMUNE1);
            pdfTextStripperByArea.addRegion("titre2",DocumentParam.TITRE2);
            pdfTextStripperByArea.addRegion("nom2",DocumentParam.NOM2);
            pdfTextStripperByArea.addRegion("prenom2",DocumentParam.PRENOM2);
            pdfTextStripperByArea.addRegion("nommarital2",DocumentParam.NOMMARITAL2);
            pdfTextStripperByArea.addRegion("participation2",DocumentParam.PARTICIPATION2);
            pdfTextStripperByArea.addRegion("nombrepart2",DocumentParam.NOMBREPART2);
            pdfTextStripperByArea.addRegion("departement2",DocumentParam.DEPARTEMENT2);
            pdfTextStripperByArea.addRegion("commune2",DocumentParam.COMMUNE2);




            pdfTextStripperByArea.extractRegions(pdPage);


            Map<String,String> docparticipation=new HashMap<>();

            //Reformatage du texte
            for (int j = 0; j <pdfTextStripperByArea.getRegions().size() ; j++) {

                String libelle =gestionDocumentService.converterdoc(pdfTextStripperByArea.getRegions().get(j));
                String valeur = gestionDocumentService.converterdoc(pdfTextStripperByArea.getTextForRegion(pdfTextStripperByArea.getRegions().get(j)));
                docparticipation.put(libelle,valeur);

            }


            //CREATION OBJET ANNEXE

            Participation participation=new Participation();

            participation.setSiret(docparticipation.get("siret"));

            participation.setTitre1(docparticipation.get("titre1"));
            participation.setNom1(docparticipation.get("nom1"));
            participation.setPrenom1(docparticipation.get("prenom1"));
            participation.setNommarital1(docparticipation.get("nommarital1"));
            participation.setParticipation1(docparticipation.get("participation1"));
            participation.setNombrepart1(docparticipation.get("nombrepart1"));
            participation.setDepartement1(docparticipation.get("departement1"));
            participation.setCommune1(docparticipation.get("commune1"));

            participation.setTitre2(docparticipation.get("titre2"));
            participation.setNom2(docparticipation.get("nom2"));
            participation.setPrenom2(docparticipation.get("prenom2"));
            participation.setNommarital2(docparticipation.get("nommarital2"));
            participation.setParticipation2(docparticipation.get("participation2"));
            participation.setNombrepart2(docparticipation.get("nombrepart2"));
            participation.setDepartement2(docparticipation.get("departement2"));
            participation.setCommune2(docparticipation.get("commune2"));


            //sauvegarde de l'objet dans la base

           participationRepository.save(participation);
           return participation;


        } catch (IOException e) {
            e.printStackTrace();
        }





        return null;
    }
}
