package com.banque.credit;

import com.banque.credit.entities.AppUser;
import com.banque.credit.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class UserController  {

    @Autowired
    private AccountService accountService;

    @GetMapping("/users")
    public List<AppUser> AllUsers(){
        return accountService.loadAllUsers();
    }

    @PostMapping("/register")
    public AppUser Register(@RequestBody UserForm userForm){
        return accountService.saveUser(
                userForm.getUsername(),
                userForm.getPassword(),
                userForm.getConfirmedpassword(),
                userForm.getNom(),
                userForm.getPrenom(),
                userForm.getEmail(),
                userForm.getSociete(),
                userForm.getSiretClient(),
                userForm.getTelephone(),
                userForm.getAdresse(),
                userForm.getCodePostal(),
                userForm.getVille());
    }


}
@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedpassword;
    private String nom;
    private String prenom;
    private String email;
    private String societe;
    private String siretClient;
    private String telephone;
    private String adresse;
    private String codePostal;
    private String ville;


}
