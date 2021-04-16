package com.acostadaniel.projecte.model.serveis;


import com.acostadaniel.projecte.model.entitats.Usuari;
import com.acostadaniel.projecte.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RepositoriUsuaris repositoriUsuaris;


    @PostConstruct
    public void init(){
        if (!repositoriUsuaris.existsById("admin")){
            repositoriUsuaris.save(new Usuari("admin", "admin", "ADMIN"));
        }
    }

    public void addUser(Usuari usuari){
        repositoriUsuaris.save(usuari);
    }



    public Usuari getByUserName(String name){
        return repositoriUsuaris.findById(name).orElse(null);
    }




}
