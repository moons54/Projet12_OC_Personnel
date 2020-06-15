package com.banque.credit.service;

import com.banque.credit.Dao.BilanRepository;
import com.banque.credit.entities.Bilan;
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
public class GestionBilanServiceImpl implements GestionBilanService {


    @Autowired
    BilanRepository bilanRepository;

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;

    @Override
    public Bilan addBilan(PDPage pdPage,String refdossier) {
        Bilan bilan=new Bilan();
        try {

            PDFTextStripperByArea pdfTextStripperByArea=new PDFTextStripperByArea();

            //CREATION DES ZONES DE TEXTES A RECCUPPER AVEC LIBELLES CORRESPONDANT
            pdfTextStripperByArea.addRegion("libelle",DocumentParam.IDENTIFICATION_DOC);
            pdfTextStripperByArea.addRegion("siret",DocumentParam.SIRET);
            pdfTextStripperByArea.addRegion("duree",DocumentParam.DUREE_EXERCICE);
            pdfTextStripperByArea.addRegion("annee",DocumentParam.ANNEE_EXERCICE);
            pdfTextStripperByArea.addRegion("totalimmo",DocumentParam.TOTAL_IMMOBILISATION);
            pdfTextStripperByArea.addRegion("dispo",DocumentParam.DISPONIBILITE);
            pdfTextStripperByArea.addRegion("totalactif",DocumentParam.TOTAL_ACTIF);
            pdfTextStripperByArea.addRegion("capital",DocumentParam.CAPITAL);
            pdfTextStripperByArea.addRegion("report",DocumentParam.REPORT);
            pdfTextStripperByArea.addRegion("resultatExercice",DocumentParam.RES_EXERCICE);
            pdfTextStripperByArea.addRegion("totalFP",DocumentParam.TOTAL_CAPITAUX);
            pdfTextStripperByArea.addRegion("fournisseur",DocumentParam.FOURNISSEUR);
            pdfTextStripperByArea.addRegion("autresdette",DocumentParam.AUTRESDETTES);
            pdfTextStripperByArea.addRegion("totaldettes",DocumentParam.TOTALDETTES);
            pdfTextStripperByArea.addRegion("totalbilan",DocumentParam.TOTALBILAN);




            pdfTextStripperByArea.extractRegions(pdPage);


            Map<String,String> docbilan=new HashMap<>();

            //Reformatage du texte
            for (int j = 0; j <pdfTextStripperByArea.getRegions().size() ; j++) {

                String libelle = gestionDocumentService.converterdoc(pdfTextStripperByArea.getRegions().get(j));
                String valeur = gestionDocumentService.converterdoc(pdfTextStripperByArea.getTextForRegion(pdfTextStripperByArea.getRegions().get(j)));
                docbilan.put(libelle,valeur);

            }

            //CREATION OBJET BILAN
            bilan.setNumeroKbis(docbilan.get("siret"));
            bilan.setAnnee(docbilan.get("annee"));
            bilan.setDuree(docbilan.get("duree"));
            bilan.setTotalImmobilisation(docbilan.get("totalimmo"));
            bilan.setDisponibilite(docbilan.get("dispo"));
            bilan.setTotalactif(docbilan.get("totalactif"));
            bilan.setCapital(docbilan.get("capital"));
            bilan.setReport(docbilan.get("report"));
            bilan.setResultatexercice(docbilan.get("resultatExercice"));
            bilan.setFondPropre(docbilan.get("totalFP"));
            bilan.setFournisseur(docbilan.get("fournisseur"));
            bilan.setAutresdettes(docbilan.get("autresdette"));
            bilan.setTotaldettes(docbilan.get("totaldettes"));
            bilan.setTotalbilan(docbilan.get("totalbilan"));
            bilan.setId(refdossier);

            //sauvegarde de l'objet dans la base
         //   bilanRepository.save(bilan);
            gestionDocumentService.ratiosComptable(bilan);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bilan;
    }

    @Override
    public Bilan findbysiret(String kbis) {
        return bilanRepository.findBilanByNumeroKbis(kbis);
    }
}
