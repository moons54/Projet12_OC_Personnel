package com.banque.credit;

import com.banque.credit.dao.AppUserRepository;
import com.banque.credit.entities.AppRole;
import com.banque.credit.entities.AppUser;
import com.banque.credit.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class SecServiceApplicationTests {

    @Autowired
    AccountServiceImpl accountService;

    @MockBean
    AppUserRepository appUserRepository;

    @MockBean
    AppRole appRole;

    @Test
    public void getLoadAllUsers() {
        when(appUserRepository.findAll()).thenReturn(
                Stream.of(new AppUser(Long.valueOf(1),"j345","123456",true,"doe","john","john.doe@gmail.com","masociete",
                        "234123345","065544555","villa 3,4 rue des bosquets","31222","Bordeaux",null),
                        new AppUser(Long.valueOf(2),"B123","654321",true,"doe","reali","john.foe@gmail.com","masociete",
                                "234123345","0675453322","rues des acacias","31222","Toulouse",null)).collect(Collectors.toList()));
        Assert.assertEquals(2,accountService.loadAllUsers().size());
    }

    @Test
    void contextLoads() {

    }

}
