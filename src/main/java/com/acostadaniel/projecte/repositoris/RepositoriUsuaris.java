package com.acostadaniel.projecte.repositoris;

import com.acostadaniel.projecte.model.entitats.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends JpaRepository<Usuari,String> {
//    Usuari findByUsername(String username);

}
