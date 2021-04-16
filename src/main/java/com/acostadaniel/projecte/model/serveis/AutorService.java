package com.acostadaniel.projecte.model.serveis;

import com.acostadaniel.projecte.model.entitats.Autor;
import com.acostadaniel.projecte.model.entitats.Direccion;
import com.acostadaniel.projecte.repositoris.AutorRepo;
import com.acostadaniel.projecte.repositoris.DireccionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepo autorRepo;

    @Autowired
    private DireccionRepo direccionRepo;

    @PostConstruct
    public void init(){
        if (!autorRepo.existsById(1)){
            autorRepo.save(new Autor(1, "Anónimo", null));
        }
    }


    public void addNewAutor(Autor autor, Direccion direccion){
        direccionRepo.save(direccion);
        autorRepo.save(new Autor(autor.getIdAutor(), autor.getNombre(), direccion));
    }

    public List<Autor> getAutors(){
        return autorRepo.findAll();
    }

    public void deleteAutor(int id){
        autorRepo.deleteById(id);
    }


    public List<Autor> getAutorsByName(){
        List<Autor> lista = autorRepo.findAll();
        lista.sort(new Comparator<Autor>() {
            @Override
            public int compare(Autor a1, Autor a2) {
                return a1.getNombre().compareTo(a2.getNombre());
            }
        });

        return lista;
    }

    public List<Autor> getAutorsById(){
        List<Autor> lista = autorRepo.findAll();
        lista.sort(new Comparator<Autor>() {
            @Override
            public int compare(Autor a1, Autor a2) {
                return a1.getIdAutor() - a2.getIdAutor();
            }
        });
        return lista;
    }
}
