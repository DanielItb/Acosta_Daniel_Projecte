package com.acostadaniel.projecte.controladors;

import com.acostadaniel.projecte.model.entitats.Libro;
import com.acostadaniel.projecte.model.serveis.AutorService;
import com.acostadaniel.projecte.model.serveis.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;


    @GetMapping("/nuevolibro")
    public String addLibro(Model model){
        model.addAttribute("libroForm", new Libro());
        model.addAttribute("autores", autorService.getAutors());
        return "addlibro";
    }


    @PostMapping("/nuevolibro/submit")
    public String addLibroSubmit(@ModelAttribute("libroForm") Libro libro){
        System.out.println(libro);
        libroService.addNewLibro(libro);
        return "index";
    }

    @GetMapping("/listalibros")
    public String listarLibros(Model model){
        model.addAttribute("listaLibros", libroService.getLibros());
        return "librolist";
    }

    @GetMapping("/tablaautor/view/{id}")
    public String verLibrosAutor(@PathVariable("id") int id, Model m){
        m.addAttribute("listaLibros",libroService.getLibrosByAutor(id) );
        return "librolist";
    }


    @GetMapping("/tablalibro/eliminar")
    public String eliminarLibro(@RequestParam("id") int id){
        libroService.deleteLibro(id);
        return "redirect:/listalibros";
    }


    @GetMapping("/libroslist/byautor")
    public String sortLibroByAutor(Model model){
        model.addAttribute("listaLibros", libroService.sortLibrosByAutorName());
        return "librolist";
    }

    @GetMapping("/libroslist/bytitulo")
    public String sortLibroByTitulo(Model model){
        model.addAttribute("listaLibros", libroService.sortLibrosByTitulo());
        return "librolist";
    }


    @GetMapping("/libroslist/byid")
    public String sortLibroById(Model model){
        model.addAttribute("listaLibros", libroService.sortLibrosById());
        return "librolist";
    }
}
