package com.acostadaniel.projecte.repositoris;


import com.acostadaniel.projecte.model.entitats.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<Libro, Integer> {
}
