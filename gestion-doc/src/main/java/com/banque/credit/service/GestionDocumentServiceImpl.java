package com.banque.credit.service;

import com.banque.credit.Dao.BilanRepository;
import com.banque.credit.Dao.RatiosRepository;
import com.banque.credit.Dao.SoldeIntermediaireGestionRepository;
import com.banque.credit.entities.*;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Transactional
@Service
public class GestionDocumentServiceImpl implements GestionDocumentService {

    @Autowired
    BilanRepository bilanRepository;

    @Autowired
    SoldeIntermediaireGestionRepository soldeIntermediaireGestionRepository;

    @Autowired
    RatiosRepository ratiosRepository;

    @Autowired
    GestionBilanServiceImpl gestionBilanService;

    @Autowired
    GestionResultatServiceImpl gestionResultatService;

    @Autowired
    GestionAnnexeServiceImpl gestionAnnexeService;


    Bilan bilan = new Bilan();
    Resultat resultat = new Resultat();
    SoldeIntermediaireGestion soldeIntermediaireGestion = new SoldeIntermediaireGestion();


    @Override
    public void addDoc(File file, String refDossier) {

        //introduction du fichier liasse fiscale numérisée

        try {

            PDDocument document = PDDocument.load(file);
            PDFTextStripperByArea pdfTextStripperByArea=new PDFTextStripperByArea();
            pdfTextStripperByArea.addRegion("libelle",DocumentParam.IDENTIFICATION_DOC);


            for (int i=0;i<document.getPages().getCount();i++) {
                PDPage doc = document.getPage(i);
                pdfTextStripperByArea.extractRegions(doc);
                String lib =pdfTextStripperByArea.getTextForRegion("libelle");



                 if (lib.contains("2033-A")){
                    //OCR SUR LE DOCUMENT BILAN PUIS SAUVEGARDE DANS LA BASE

                     bilan=gestionBilanService.addBilan(doc,refDossier);
                     System.out.println(bilan);
                }
                else if(lib.contains("2033-B")){
                    //OCR SUR LE DOCUMENT COMPTE RESULTAT PUIS SAUVEGARDE DANS LA BASE
                     resultat=gestionResultatService.addExercice(doc,refDossier);
                     analyseComptable(resultat);
                }

                else if (lib.contains("2033-F")){
                    //OCR SUR LE DOCUMENT COMPOSITION CAPITAL SOCIAL PUIS SAUVEGARDE DANS LA BASE
                   Annexe annexe= gestionAnnexeService.addAnnexe(doc);
                     System.out.println(annexe);
                }

                if(bilan!=null && resultat!=null) {



                    bilan.setResultat(resultat);

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bilanRepository.save(bilan);

    }

    //METHODE DE CONVERSION DES CARACTERES
    //Notamment les chiffres entre () qui sont converti en chiffre négatif
    public String converterdoc(String str){
        String convert;

        if (str.startsWith("(")) {
            convert=str.trim().replace(" ","").replace("(", "-").replace(")","");
        }
        else {

            convert = str.trim().replace(" ", "");
        }
        System.out.println(convert);
        return convert;
    }

    public void splitdoc(PDDocument document) throws IOException {
        Splitter splitter=new Splitter();

        List<PDDocument> pages=splitter.split(document);

        Iterator<PDDocument> iterator=pages.listIterator();

        int i=2;

        while (iterator.hasNext()){

            PDDocument pdfdocument = iterator.next();
            pdfdocument.save("src/main/resources/document/documentApproved"+i+".pdf");

        }
    };

    public Integer convertstring(String str){

        if (!str.isEmpty()){
            Integer st=Integer.parseInt(str);
            return st;
        }else {
            Integer st=0;


            return st;
        }
    }

    //@Override
    public void analyseComptable(Resultat resultat) {



        //Vente - Achat - Variation de stock de march
        Integer vente = convertstring(resultat.getProductionVenduBien());
        Integer achat = convertstring(resultat.getAchatsMarchandises());
        Integer variation = convertstring(resultat.getVariationStockMarchandise());
        Integer marge= vente-achat-variation;
        soldeIntermediaireGestion.setMarge(marge.toString());
        System.out.println("val de marge"+soldeIntermediaireGestion.getMarge());

        //Production vendu + variation de production stockée + production immobilisé
        Integer pvendubien = convertstring(resultat.getProductionVenduBien());
        Integer pvenduservice = convertstring(resultat.getProductionVenduService());
        Integer prodimmobilise = convertstring(resultat.getProductionimmobilise());
        Integer productionExercice = pvendubien + pvenduservice + prodimmobilise;
        soldeIntermediaireGestion.setProductionExercice(productionExercice.toString());

        //Production + Marge commercial
        Integer productionmarge = productionExercice + marge;
        soldeIntermediaireGestion.setProductionMarge(productionmarge.toString());

        //ProductionMarge - Achat stockés - variation de stock et appro - autres charges externe
        Integer achatstockes = convertstring(resultat.getVariationStockMatierePremiere());
        Integer variationStock = convertstring(resultat.getVariationStockMarchandise());
        Integer autresCharges = convertstring(resultat.getChargesExternes());
        Integer valeurAjoute = productionmarge - achatstockes - variationStock - autresCharges;
        soldeIntermediaireGestion.setValeurAjoutee(valeurAjoute.toString());


        //Valeur ajouté - sub exploitation - impotstaxes - salaire traitement -charges sociales
        Integer subvention = convertstring(resultat.getSubventionExploitationRecu());
        Integer impotsTaxes = convertstring(resultat.getImpotsTaxes());
        Integer salaireTraitmement = convertstring(resultat.getRemunerationPersonnel());
        Integer chargesSociales = convertstring(resultat.getChargesSociales());

        Integer excedentBrutExploitation = valeurAjoute - subvention - impotsTaxes
                - salaireTraitmement - chargesSociales;
        soldeIntermediaireGestion.setExcedentBrutExploitation(excedentBrutExploitation.toString());

        //EBE + reprise dot amort + autre produits d'exploitation + transfert charges
        // - dot aux amortissements prov - autres charges de gestion courantes
        Integer repriseDotation = convertstring(resultat.getDotationAmmortissement());
        Integer autresProduits = convertstring(resultat.getAutresProduits());
        //Integer transfertCharges = convertstring(resultat.get)
        Integer dotationAmmortissemnts = convertstring(resultat.getDotationAmmortissement())+convertstring(resultat.getDotationProvision());
        // Integer autresCharges = convertstring(resultat.getA)
        Integer resultatExploitation = excedentBrutExploitation + repriseDotation + autresProduits + dotationAmmortissemnts;
        soldeIntermediaireGestion.setResultatExploitation(resultatExploitation.toString());

        //RE  + reprise sur amortissement et provision - charges financiere
        //  Integer chargesFinancieres = convertstring(resultat.getch)
        Integer resutatCourant = resultatExploitation;
        soldeIntermediaireGestion.setResultatcourant(resutatCourant.toString());

        Integer resultatExercice = resutatCourant;
        soldeIntermediaireGestion.setResultatExercice(resultatExercice.toString());


        //resultat.setSoldeIntermediaireGestion(soldeIntermediaireGestion);


        //soldeIntermediaireGestion.setResultat(resultat);
        soldeIntermediaireGestionRepository.save(soldeIntermediaireGestion);
        // gestionResultatService.resultatRepository.save(resultat);
        resultat.setSoldeIntermediaireGestion(soldeIntermediaireGestion);
        gestionResultatService.resultatRepository.save(resultat);



    }

    @Override
    public void ratiosComptable(Bilan bilan) {



        //Calcul couverture des capitaux propres
        // Capitaux propres /ressources stables

        double capitaux = convertstring(bilan.getFondPropre());
        double ressources =  convertstring(bilan.getTotalbilan());

        Double couverture= capitaux/ressources;

        System.out.println("val ressource"+ressources);
        System.out.println("val capitaux" + capitaux);


        //Calcul Rentabilite financière
        // RN / capitaux propres

        double resultatNet = convertstring(bilan.getResultatexercice());

        Double rentabiliteFinanciere = resultatNet/capitaux;


         //calcul endettement
        //dette MLT / CAF

        double dettes = convertstring(bilan.getTotaldettes());

        System.out.println("valeur"+dettes);
          double caf = resultatNet;
        Double endettement = dettes / caf;

        Ratios ratios=new Ratios();
        ratios.setCouverture(couverture.toString());
        ratios.setRentabiliteFinanciere(rentabiliteFinanciere.toString());
        ratios.setCapaciteRemboursement(endettement.toString());

        ratiosRepository.save(ratios);

        bilan.setRatios(ratios);
        bilanRepository.save(bilan);

    }
}
