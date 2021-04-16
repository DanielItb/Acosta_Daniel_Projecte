package com.acostadaniel.projecte.model.entitats;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTOR")
public class Autor {

    @Id
    @Column(name = "AUTOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_DIRECCION")
    private Direccion direccion;

    @OneToMany(mappedBy = "autor", cascade =  CascadeType.ALL)
    private List<Libro> libros = new ArrayList<>();


    public Autor(int idAutor, String nombre, Direccion direccion) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Autor() {
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }


    @Override
    public String toString() {
        return nombre;
    }


//    @Override
//    public String toString() {
//        return "Autor{" +
//                "idAutor=" + idAutor +
//                ", nombre='" + nombre + '\'' +
//                ", direccion=" + direccion + "}'";
//    }
}
