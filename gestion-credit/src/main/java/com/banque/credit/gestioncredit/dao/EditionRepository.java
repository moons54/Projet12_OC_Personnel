package com.banque.credit.gestioncredit.dao;

import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.entities.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EditionRepository extends JpaRepository<Edition,Long> {


    public Edition findAllById(Long Id);

    public List<Edition> findAllByStatuts(String statuts);
}
