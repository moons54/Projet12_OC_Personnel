package com.banque.credit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
@Data
@AllArgsConstructor @NoArgsConstructor
public class Annexe {

	@Id
	private String id;

	private String siret;
	private String nombreParticipant;
	private String numeropage;
	private String nombrePage;

	@DBRef
	private Collection<Participation> participations=new ArrayList<>();

}