package com.banque.credit.Dao;

import com.banque.credit.entities.Participation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ParticipationRepository extends MongoRepository<Participation,String> {

    public Participation findParticipationBySiret(String siret);

    public Participation findBy(String id);

    public Participation findByNom1(String name);




}
