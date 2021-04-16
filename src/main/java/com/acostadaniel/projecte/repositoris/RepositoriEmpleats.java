package com.acostadaniel.projecte.repositoris;

import com.acostadaniel.projecte.model.entitats.Empleats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriEmpleats extends JpaRepository<Empleats, Integer> {
}
