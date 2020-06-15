package com.banque.credit.service;

import com.banque.credit.Dao.BilanRepository;
import com.banque.credit.Dao.ResultatRepository;
import com.banque.credit.entities.Resultat;
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
public class GestionResultatServiceImpl implements GestionResultatService {

    @Autowired
    ResultatRepository resultatRepository;

    @Autowired
    BilanRepository bilanRepository;

    @Autowired
    GestionDocumentServiceImpl gestionDocumentService;




    @Override
    public Resultat addExercice(PDPage pdPage, String refDossier) {
        Resultat resultat=new Resultat();
        try {

            PDFTextStripperByArea pdfTextStripperByArea=new PDFTextStripperByArea();

            //Colonne Compte de resultat valeur
            pdfTextStripperByArea.addRegion("libelle",DocumentParam.IDENTIFICATION_DOC);
            pdfTextStripperByArea.addRegion("productionvenduservice",DocumentParam.PRODUCTION_VENDU_SERVICE);
            pdfTextStripperByArea.addRegion("productionvendubien",DocumentParam.PRODUCTION_VENDU_BIEN);
            pdfTextStripperByArea.addRegion("productionstockee",DocumentParam.PRODUCTION_STOCKEE);
            pdfTextStripperByArea.addRegion("productionimmobilisee",DocumentParam.PRODUCTION_IMMOBILISE);
            pdfTextStripperByArea.addRegion("subventionexploitationrecu",DocumentParam.SUBVENTION_EXPLOITATION_RECU);
            pdfTextStripperByArea.addRegion("autresproduits",DocumentParam.AUTRES_PRODUITS);
            pdfTextStripperByArea.addRegion("achatmarchandises",DocumentParam.ACHATS_MARCHANDISES);
            pdfTextStripperByArea.addRegion("variationstockmarchandise",DocumentParam.VARIATION_STOCK_MARCHANIDES);
            pdfTextStripperByArea.addRegion("achatmatierepremiere",DocumentParam.ACHATS_MATIERES_PREMIERES);
            pdfTextStripperByArea.addRegion("variationstockmatierepremiere",DocumentParam.VARIATION_STOCK_MATIERES_PREMIERES);

            pdfTextStripperByArea.addRegion("totalproduit",DocumentParam.TOTAL_PRODUIT);
            pdfTextStripperByArea.addRegion("impotstaxes",DocumentParam.IMPOTS_TAXES);

            pdfTextStripperByArea.addRegion("chargesexternes",DocumentParam.CHARGES_EXTERNES);
            pdfTextStripperByArea.addRegion("remuneration",DocumentParam.REMUNERATION_PERSONNEL);
            pdfTextStripperByArea.addRegion("chargessociales",DocumentParam.CHARGES_SOCIALES);

            pdfTextStripperByArea.addRegion("dotationammortissement",DocumentParam.DOTATION_AMMORTISSEMENT);
            pdfTextStripperByArea.addRegion("dotationprovision",DocumentParam.DOTATION_PROVISION);

            pdfTextStripperByArea.addRegion("chargesexploi",DocumentParam.CHARGES_EXPLOITATION);
            pdfTextStripperByArea.addRegion("resultatexploitation",DocumentParam.RESULTATS_EXPLOITATION);
            pdfTextStripperByArea.addRegion("beneficeperte",DocumentParam.BENEFICE_PERTE);
            pdfTextStripperByArea.addRegion("resultatfiscal",DocumentParam.RESULTAT_FISCAL);


            pdfTextStripperByArea.extractRegions(pdPage);

            Map<String,String> mapresultat=new HashMap<>();

            //REFORMATAGE DU TEXTE
            //INSERTION DANS LA MAP libelle/valeur
            for (int j = 0; j <pdfTextStripperByArea.getRegions().size() ; j++) {

                String libelle = gestionDocumentService.converterdoc(pdfTextStripperByArea.getRegions().get(j));
                String valeur = gestionDocumentService.converterdoc(pdfTextStripperByArea.getTextForRegion(pdfTextStripperByArea.getRegions().get(j)));
                mapresultat.put(libelle,valeur);
            }

            //CREATION INSTANCE RESULTAT
            resultat.setChiffreAffaire(mapresultat.get("totalproduit"));
            resultat.setChargesExternes(mapresultat.get("chargesexternes"));
            resultat.setRemunerationPersonnel(mapresultat.get("remuneration"));
            resultat.setProductionVenduBien(mapresultat.get("productionvendubien"));
            resultat.setProductionVenduService(mapresultat.get("productionvenduservice"));
            resultat.setProductionStockee(mapresultat.get("productionstockee"));
            resultat.setProductionimmobilise(mapresultat.get("productionimmobilisee"));
            resultat.setSubventionExploitationRecu(mapresultat.get("subventionexploitationrecu"));
            resultat.setAutresProduits(mapresultat.get("autresproduits"));
            resultat.setAchatsMarchandises(mapresultat.get("achatmarchandises"));
            resultat.setVariationStockMarchandise(mapresultat.get("variationstockmarchandise"));
            resultat.setAchatsMatierePremiere(mapresultat.get("achatmatierepremiere"));
            resultat.setVariationStockMatierePremiere(mapresultat.get("variationstockmatierepremiere"));
            resultat.setImpotsTaxes(mapresultat.get("impotstaxes"));
            resultat.setDotationAmmortissement(mapresultat.get("dotationammortissement"));
            resultat.setDotationProvision(mapresultat.get("dotationprovision"));
            resultat.setChargesExploitation(mapresultat.get("chargesexploi"));
            resultat.setChargesSociales(mapresultat.get("chargessociales"));
            resultat.setResultatExploitation(mapresultat.get("resultatexploitation"));
            resultat.setChargesExternes(mapresultat.get("chargesexternes"));
            resultat.setBeneficePErte(mapresultat.get("beneficeperte"));
            resultat.setResultatfiscal(mapresultat.get("resultatfiscal"));


            //INSERTION DANS LA BD
            resultatRepository.save(resultat);

      //    gestionDocumentService.analyseComptable(resultat);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultat;
    }
}
