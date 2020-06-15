package com.banque.credit.Dao;

import com.banque.credit.entities.Resultat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ResultatRepository extends MongoRepository<Resultat,String> {

}
