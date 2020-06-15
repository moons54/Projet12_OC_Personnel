package com.banque.credit.Dao;


import com.banque.credit.entities.Ratios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface RatiosRepository extends MongoRepository<Ratios,String> {


}
