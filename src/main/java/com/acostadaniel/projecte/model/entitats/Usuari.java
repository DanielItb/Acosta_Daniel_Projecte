package com.acostadaniel.projecte.model.entitats;


import lombok.Data;
import javax.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;

@Data
@Entity
public class Usuari {
    @Id
    private String username;
    private String password;
    private String rol;

    public Usuari() {
        rol = "USER";
    }

    public Usuari(String username, String password, String rol) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.rol = rol;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
