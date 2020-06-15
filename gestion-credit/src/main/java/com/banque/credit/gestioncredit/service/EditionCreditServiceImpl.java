package com.banque.credit.gestioncredit.service;

import com.banque.credit.gestioncredit.dao.EditionRepository;
import com.banque.credit.gestioncredit.entities.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EditionCreditServiceImpl implements EditionCreditService {

    @Autowired
    EditionRepository editionRepository;



    @Override
    public List<Edition> editionsdesOffres(String type) {
        List<Edition> editionList=new ArrayList<>();
        if (type!=null){

           editionList= editionRepository.findAllByStatuts(type);

            }

        return editionList;
    }

    @Override
    public Edition addEditionCredit(Edition edition) {
        return null;
    }

    @Override
    public Edition removeEdition(Edition edition) {
        return null;
    }

    @Override
    public Edition changementStatutEdition(Edition edition) {
        return null;
    }
}
