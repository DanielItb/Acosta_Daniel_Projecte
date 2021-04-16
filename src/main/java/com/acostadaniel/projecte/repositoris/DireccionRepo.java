package com.acostadaniel.projecte.repositoris;


import com.acostadaniel.projecte.model.entitats.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepo extends JpaRepository<Direccion, Integer> {
}
