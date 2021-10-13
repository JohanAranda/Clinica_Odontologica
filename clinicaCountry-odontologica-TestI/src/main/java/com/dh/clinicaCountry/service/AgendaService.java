package com.dh.clinicaCountry.service;

import com.dh.clinicaCountry.model.Agenda;
import com.dh.clinicaCountry.repository.impl.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public Agenda registrarAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public List<Agenda> listar() {
        return agendaRepository.findAll();
    }

    public void eliminar(Integer id) {
        agendaRepository.deleteById(id);
    }

    public Agenda actualizar(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Optional<Agenda> buscar(Integer id) {
        return agendaRepository.findById(id);
    }

}
