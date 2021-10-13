package com.dh.clinicaCountry.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Agendas")
public class Agenda {

    @Id
    @SequenceGenerator(name = "agenda_sequence", sequenceName = "agenda_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_sequence")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;
    private Date date;

    public Agenda() {
    }

    public Agenda(Paciente paciente, Dentista dentista, Date date) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
