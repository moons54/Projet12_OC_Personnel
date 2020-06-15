package com.banque.credit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor @NoArgsConstructor
public class Bilan {

	@Id
	private String id;

	private String structure;
	private String Intitule;
	private String numeroKbis;
	private String duree;
	private String annee;
	private String totalImmobilisation;
	private String disponibilite;
	private String totalactif;
	private String capital;
	private String report;
	private String resultatexercice;
	private String fondPropre;
	private String fournisseur;
	private String autresdettes;
	private String posteClient;
	private String totaldettes;
	private String totalbilan;


	@DBRef
	private Resultat resultat;

	@DBRef
	private Ratios ratios;






	public void controleCoherence() {
		// TODO - implement Bilan.controleCoherence
		throw new UnsupportedOperationException();
	}

	public void calculRatio() {
		// TODO - implement Bilan.calculRatio
		throw new UnsupportedOperationException();
	}

	public void calculScore() {
		// TODO - implement Bilan.calculScore
		throw new UnsupportedOperationException();
	}

}
