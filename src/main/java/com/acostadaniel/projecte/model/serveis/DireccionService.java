package com.acostadaniel.projecte.model.serveis;

import com.acostadaniel.projecte.model.entitats.Direccion;
import com.acostadaniel.projecte.repositoris.DireccionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepo direccionRepo;

    public List<Direccion> getDirecciones(){
        return direccionRepo.findAll();
    }
}
