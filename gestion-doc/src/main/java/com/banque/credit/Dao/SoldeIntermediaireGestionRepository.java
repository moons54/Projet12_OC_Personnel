package com.banque.credit.Dao;

import com.banque.credit.entities.SoldeIntermediaireGestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SoldeIntermediaireGestionRepository extends MongoRepository<SoldeIntermediaireGestion,String> {


}
