package com.dh.clinicaCountry.controller;

import com.dh.clinicaCountry.model.Dentista;

import com.dh.clinicaCountry.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dentistas")
public class DentistaController {
    @Autowired
    private DentistaService dentistaService;

    @PostMapping()
    public ResponseEntity<Dentista> registrarDentista(@RequestBody Dentista dentista) {

        return ResponseEntity.ok(dentistaService.registrarDentista(dentista));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscar(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscar(id).orElse(null);

        return ResponseEntity.ok(dentista);
    }

    @PutMapping()
    public ResponseEntity<Dentista> actualizar(@RequestBody Dentista dentista) {
        ResponseEntity<Dentista> response = null;

        if (Dentista.getId() != null && dentista.buscar(dentista.getId()).isPresent())
            response = ResponseEntity.ok(DentistaService.actualizar(dentista));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (DentistaService.buscar(id).isPresent()) {
            DentistaService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Dentista>> buscarTodos(){
        return ResponseEntity.ok(DentistaService.buscarTodos());
    }



}
