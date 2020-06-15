package com.banque.credit.gestioncredit.dao;

import com.banque.credit.gestioncredit.entities.Credit;
import com.banque.credit.gestioncredit.entities.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DecisionRepository extends JpaRepository<Decision,Long> {

 public Decision findAllById(long id);




}
