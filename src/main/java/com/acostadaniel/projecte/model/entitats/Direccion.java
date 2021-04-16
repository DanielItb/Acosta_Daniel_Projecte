package com.acostadaniel.projecte.model.entitats;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DIRECCION")
public class Direccion implements Serializable {

    @Id
    @Column(name = "ID_DIRECCION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDireccion;

    @Column(name = "CALLE")
    private String calle;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "PAIS")
    private String pais;



    public Direccion(int idDireccion, String calle, String ciudad, String pais) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Direccion() {
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

//    @Override
//    public String toString() {
//        return calle + ", " + ciudad + ", " + pais;
//    }


    @Override
    public String toString() {
        return "Direccion{" +
                "idDireccion=" + idDireccion +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
