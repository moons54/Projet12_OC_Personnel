package com.banque.credit.service;

import com.banque.credit.entities.AppRole;
import com.banque.credit.entities.AppUser;

import java.util.List;


public interface AccountService {
    //public AppUser saveUser(String username, String password, String confirmpassword);
    public AppUser saveUser(String username, String password, String confirmedPassword, String nom, String prenom, String email, String societe,
                            String siretClient, String telephone, String adresse, String codePostal, String ville);

    public AppRole save(AppRole appRole);

    public AppUser loadUserbyUserName(String username);

    public List<AppUser> loadAllUsers();

    public void addRoleToUser(String username, String rolename);


}
