package com.banque.credit;

import com.banque.credit.entities.AppRole;
import com.banque.credit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class SecServiceApplication {

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }

    //Nous injections la couche account service
    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {

            repositoryRestConfiguration.exposeIdsFor(AccountService.class);
           accountService.save(new AppRole(null,"ADMIN"));
            accountService.save(new AppRole(null,"USER"));

            Stream.of("admin").forEach(u->{
                accountService.saveUser(u,"123456","123456",
                        "paulson","robert","paulson.rob@gmail.com","myfrabriq",
                        "543456143","0645361155","rue des tilleuils","95000","paris");
            });
            accountService.addRoleToUser("admin","ADMIN");
            Stream.of("barroom").forEach(u->{
                accountService.saveUser(u,"123456","123456",
                        "gilevitch","eric","gilet.er@gmail.com","Brasserie OPEN ROOM",
                        "31144222100013","0645361534","14 rue des bosquet","95000","paris");
            });
            accountService.addRoleToUser("barroom","user");
        };

    }

    @Bean
    BCryptPasswordEncoder getBcpe(){
        return new BCryptPasswordEncoder();
    }

}
