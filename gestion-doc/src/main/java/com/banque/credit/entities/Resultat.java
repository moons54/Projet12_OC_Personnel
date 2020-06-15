package com.banque.credit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor @AllArgsConstructor
public class Resultat {

	@Id
	private String id;
	private String chiffreAffaire;
	private String productionVenduBien;
	private String productionVenduService;
	private String productionStockee;
	private String productionimmobilise;
	private String subventionExploitationRecu;
	private String autresProduits;
	private String achatsMarchandises;
	private String variationStockMarchandise;
	private String achatsMatierePremiere;
	private String variationStockMatierePremiere;
	private String impotsTaxes;
	private String chargesSociales;
	private String dotationAmmortissement;
	private String dotationProvision;
	private String chargesExternes;
	private String chargesExploitation;
	private String resultatExploitation;
	private String remunerationPersonnel;
	private String beneficePErte;
	private String resultatfiscal;

	@DBRef
	private SoldeIntermediaireGestion soldeIntermediaireGestion;

	@DBRef
	private Bilan bilan;

	@Override
	public String toString() {
		return "Resultat{" +
				"id='" + id + '\'' +
				", chiffreAffaire='" + chiffreAffaire + '\'' +
				", productionVenduBien='" + productionVenduBien + '\'' +
				", productionVenduService='" + productionVenduService + '\'' +
				", productionStockee='" + productionStockee + '\'' +
				", productionimmobilise='" + productionimmobilise + '\'' +
				", subventionExploitationRecu='" + subventionExploitationRecu + '\'' +
				", autresProduits='" + autresProduits + '\'' +
				", achatsMarchandises='" + achatsMarchandises + '\'' +
				", variationStockMarchandise='" + variationStockMarchandise + '\'' +
				", achatsMatierePremiere='" + achatsMatierePremiere + '\'' +
				", variationStockMatierePremiere='" + variationStockMatierePremiere + '\'' +
				", impotsTaxes='" + impotsTaxes + '\'' +
				", chargesSociales='" + chargesSociales + '\'' +
				", dotationAmmortissement='" + dotationAmmortissement + '\'' +
				", dotationProvision='" + dotationProvision + '\'' +
				", chargesExternes='" + chargesExternes + '\'' +
				", chargesExploitation='" + chargesExploitation + '\'' +
				", resultatExploitation='" + resultatExploitation + '\'' +
				", remunerationPersonnel='" + remunerationPersonnel + '\'' +
				", beneficePErte='" + beneficePErte + '\'' +
				", resultatfiscal='" + resultatfiscal + '\'' +
				", soldeIntermediaireGestion=" + soldeIntermediaireGestion +
				", bilan=" + bilan +
				'}';
	}

	/*
	public void calculSig() {
		// TODO - implement Resultat.calculSig
		throw new UnsupportedOperationException();
	}

	public void controleCoherence() {
		// TODO - implement Resultat.controleCoherence
		throw new UnsupportedOperationException();
	}

	public Resultat() {
		// TODO - implement Resultat.Resultat
		throw new UnsupportedOperationException();
	}

	public void calculScore() {
		// TODO - implement Resultat.calculScore
		throw new UnsupportedOperationException();
	}
*/

}
