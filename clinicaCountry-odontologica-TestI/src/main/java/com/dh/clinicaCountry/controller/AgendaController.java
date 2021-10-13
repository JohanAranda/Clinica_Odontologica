package com.dh.clinicaCountry.controller;

import com.dh.clinicaCountry.model.Agenda;
import com.dh.clinicaCountry.service.DentistaService;
import com.dh.clinicaCountry.service.PacienteService;
import com.dh.clinicaCountry.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DentistaService dentistaService;

    @PostMapping
    public ResponseEntity<Agenda> registrarAgenda(@RequestBody Agenda agenda) {
        ResponseEntity<Agenda> response;
        if (pacienteService.buscar(agenda.getPaciente().getId()).isPresent() && dentistaService.buscar(agenda.getDentista().getId()).isPresent())
            response = ResponseEntity.ok(agendaService.registrarAgenda(agenda));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;


    }

    @GetMapping
    public ResponseEntity<List<Agenda>> listar() {
        return ResponseEntity.ok(agendaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (agendaService.buscar(id).isPresent()) {
            agendaService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Agenda> actualizarAgenda(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(AgendaService.actualizar(Agenda));

    }


}
