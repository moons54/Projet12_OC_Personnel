package com.banque.credit.service;

import com.banque.credit.dao.AppRoleRepository;
import com.banque.credit.dao.AppUserRepository;
import com.banque.credit.entities.AppRole;
import com.banque.credit.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword, String nom, String prenom, String email, String societe,
                            String siretClient, String telephone, String adresse, String codePostal, String ville) {

        AppUser user=appUserRepository.findByUsername(username);

        if (user!=null) throw new RuntimeException("user already exists");

        if (!password.equals( confirmedPassword ) ) throw new RuntimeException("Please confirm your password");

        //Creation dans ce contexte de l'utilisateur

        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setNom(nom);
        appUser.setPrenom(prenom);
        appUser.setEmail(email);
        appUser.setSociete(societe);
        appUser.setSiretClient(siretClient);
        appUser.setTelephone(telephone);
        appUser.setAdresse(adresse);
        appUser.setCodePostal(codePostal);
        appUser.setVille(ville);

        //le mot de passe
        appUser.setPassword(bCryptPasswordEncoder.encode(password));


        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }


    @Override
    public AppRole save(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser loadUserbyUserName(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username , String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public List<AppUser> loadAllUsers() {
        return appUserRepository.findAll();
    }
}
