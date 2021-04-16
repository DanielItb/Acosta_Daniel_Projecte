package com.acostadaniel.projecte.seguretat;

import com.acostadaniel.projecte.model.entitats.Usuari;
import com.acostadaniel.projecte.model.serveis.UserService;
import com.acostadaniel.projecte.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class ElMeuUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

//    public UserService getUserService() {
//        return userService;
//    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuari u = userService.getByUserName(username);
        User.UserBuilder builder;

        if (u != null){
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }else throw new UsernameNotFoundException("Usuari no trobat");
        return builder.build();
    }
}

