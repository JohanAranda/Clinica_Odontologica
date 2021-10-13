package com.dh.clinicaCountry.model;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String ciudad;


    public Domicilio() {
    }

    public Domicilio(Integer id, String calle, String numero, String localidad, String ciudad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.ciudad = ciudad;
    }
    public Domicilio( String calle, String numero, String localidad, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.provincia = ciudad;
    }



    @Override
    public String toString() {
        return "Domicilio{" +
                "Id=" + id +
                ", Calle='" + calle + '\'' +
                ", Numero='" + numero + '\'' +
                ", Localidad='" + localidad + '\'' +
                ", Ciudad='" + ciudad + '\'' +
                '}';
    }
}
