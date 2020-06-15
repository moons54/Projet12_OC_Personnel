package com.banque.credit.Dao;

import com.banque.credit.entities.Bilan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface BilanRepository extends MongoRepository<Bilan,String> {

    @RestResource(path = "/bilanbykbis")
    public Bilan findBilanByNumeroKbis(@Param("kbis")String kbis);


    public Bilan findBilanById(String Id);





}
