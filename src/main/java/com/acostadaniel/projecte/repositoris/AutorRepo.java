package com.acostadaniel.projecte.repositoris;

import com.acostadaniel.projecte.model.entitats.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepo extends JpaRepository<Autor, Integer> {
}
