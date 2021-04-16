package com.acostadaniel.projecte.model.serveis;

import com.acostadaniel.projecte.model.entitats.Autor;
import com.acostadaniel.projecte.model.entitats.Libro;
import com.acostadaniel.projecte.repositoris.AutorRepo;
import com.acostadaniel.projecte.repositoris.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepo libroRepo;

    @Autowired
    private AutorRepo autorRepo;

    public void addNewLibro(Libro libro) {
        libroRepo.save(libro);
    }

    public List<Libro> getLibros(){
        return libroRepo.findAll();
    }

    public void deleteLibro(int id){
        libroRepo.deleteById(id);
    }

    public List<Libro> getLibrosByAutor(int id){
        Autor autor = autorRepo.getOne(id);
        return autor.getLibros();
    }

    public List<Libro> sortLibrosByAutorName(){
        List<Libro> lista = libroRepo.findAll();
        lista.sort(new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getAutor().getNombre().compareTo(l2.getAutor().getNombre());
            }
        });

        return lista;
    }

    public List<Libro> sortLibrosByTitulo(){
        List<Libro> lista = libroRepo.findAll();
        lista.sort(new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            }
        });

        return lista;
    }


    public List<Libro> sortLibrosById(){
        List<Libro> lista = libroRepo.findAll();
        lista.sort(new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getIdLibro() - l2.getIdLibro();
            }
        });

        return lista;
    }
}
