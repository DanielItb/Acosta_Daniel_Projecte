package com.acostadaniel.projecte.controladors;

import com.acostadaniel.projecte.model.entitats.Empleats;
import com.acostadaniel.projecte.model.serveis.EmpleatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats {
    @Autowired
    private EmpleatsService servei;

    @GetMapping("/empleats/list")
    public String llistar(Model m){
        m.addAttribute("llistaEmpleats", servei.llistat());
        return "llistat";
    }



    /* inici de l'aplicació. Anem a afegir Empleats amb un formulari*/
    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("empleatForm",new Empleats());
        return "afegir";
    }


    @PostMapping("empleats/new/submit")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleats emp){
        servei.afegir(emp);
        return "redirect:/empleats/list";
    }


    @GetMapping("/empleats/eliminar")
    public String eliminarEmpleat(@RequestParam("id") int id){
        servei.eliminarEmpleat(id);
        return "redirect:/empleats/list";
    }


    @GetMapping("/empleats/edit/{id}")
    public String substituirEmpleat(@PathVariable("id") int id, Model m){
        m.addAttribute("empleatForm", servei.consultaPerId(id));
        return "afegir";
    }

    @PostMapping("/empleats/edit/submit")
    public String substituirEmpleatFinal(@ModelAttribute("empleatForm") Empleats e){
        servei.substituirEmpleat(e);
        return "redirect:/empleats/list";
    }


    @GetMapping("/empleats/sortlist")
    public String llistarOrdenat(Model m){
        m.addAttribute("llistaEmpleats", servei.llistatOrdenatPerNom());
        return "llistat";
    }
}
