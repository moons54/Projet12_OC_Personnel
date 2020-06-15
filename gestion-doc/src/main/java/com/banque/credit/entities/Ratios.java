package com.banque.credit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor @AllArgsConstructor @ToString
public class Ratios {

	@Id
	private String id;

	//Ratio de structure
	private String couverture;

	private String rentabiliteFinanciere;

	private String capaciteRemboursement;

	private String equilibreFinancier;

	//Ratio d'exploitation
	private String fraisFinancier;

	private String poidspersonneldansleca;

	private String profitabilite;


}
