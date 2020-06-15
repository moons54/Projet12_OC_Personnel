package com.banque.credit.Dao;

import com.banque.credit.entities.Annexe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface AnnexeRepository extends MongoRepository<Annexe,String> {

    public Annexe findAllById(String id);

    public Annexe findBySiret(String Siret) throws NullPointerException;
}
