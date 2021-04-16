package com.acostadaniel.projecte.controladors;

import com.acostadaniel.projecte.model.entitats.Usuari;
import com.acostadaniel.projecte.model.serveis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registre")
    public String afegirUsuari(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("userForm",new Usuari());
        return "registre";
    }

    @PostMapping("/registre")
    public String afegirSubmit(@ModelAttribute Usuari usuari, Model model){
        Usuari user = userService.getByUserName(usuari.getUsername());

        if (user == null) {
            userService.addUser(usuari);
            return "redirect:/login";
        }else{
            model.addAttribute("userForm",new Usuari());
            model.addAttribute("exist", true);
            return "registre";
        }

    }
}
