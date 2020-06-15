package com.banque.credit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class SoldeIntermediaireGestion {

	@Id
	private String id;

	private String chiffreAffaire;
	private String marge;
	private String productionExercice;
	private String productionMarge;
	private String valeurAjoutee;
	private String excedentBrutExploitation;
	private String resultatExploitation;
	private String resultatcourant;
	private String resultatExceptionnel;
	private String resultatExercice;



}
