package com.acostadaniel.projecte.controladors;


import com.acostadaniel.projecte.model.serveis.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DireccionesControler {

    @Autowired
    private DireccionService direccionService;


    @GetMapping("/direcciones")
    public String getDirecciones(Model model){
       model.addAttribute("listaDirecciones", direccionService.getDirecciones());
       return "direcciones";
    }
}

