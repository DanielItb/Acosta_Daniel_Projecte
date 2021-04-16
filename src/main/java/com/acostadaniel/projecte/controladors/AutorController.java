package com.acostadaniel.projecte.controladors;

import com.acostadaniel.projecte.model.entitats.Autor;
import com.acostadaniel.projecte.model.entitats.Direccion;
import com.acostadaniel.projecte.model.serveis.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;


    @GetMapping("/")
    public String inicio(){
        return "index";
    }

    @GetMapping("/nuevoautor")
    public String addAutor(Model model){
        model.addAttribute("autorForm",new Autor());
        model.addAttribute("direccionForm", new Direccion());
        return "addautor";
    }


    @PostMapping("/nuevoautor/submit")
    public String addSubmit(@ModelAttribute("autorForm") Autor autor, @ModelAttribute("direccionForm")Direccion direccion){
        autorService.addNewAutor(autor, direccion);
        return "index";
    }


    @GetMapping("/listaautores")
    public String listarAutores(Model model){
        model.addAttribute("listaAutores", autorService.getAutors());
        return "autorlist";
    }


    @GetMapping("/tablaautor/byname")
    public String llistarByName(Model model){
        model.addAttribute("listaAutores", autorService.getAutorsByName());
        return "autorlist";
    }

    @GetMapping("/tablaautor/byid")
    public String llistarById(Model model){
        model.addAttribute("listaAutores", autorService.getAutorsById());
        return "autorlist";
    }


//    @DeleteMapping("/listaautores/{id}")
//    public String deleteAutor(@PathVariable("id") int id){
//        autorService.deleteAutor(id);
//        return "redirect:/listaautores";
//    }

    @GetMapping("/tablaautor/eliminar")
    public String eliminarAutor(@RequestParam("id") int id){
        autorService.deleteAutor(id);
        return "redirect:/listaautores";
    }




}
