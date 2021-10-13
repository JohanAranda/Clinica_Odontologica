package com.dh.clinicaCountry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dentistas")
public class Dentistas {
    @Id
    @SequenceGenerator(name = "dentista_sequence", sequenceName = "dentista_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentista_sequence")
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Agenda> agenda = new HashSet<>();

    public Dentistas() {
    }

    public Dentista(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Dentista(Integer id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(Set<Agenda> agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "Id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Matricula=" + matricula +
                '}';
    }
}
