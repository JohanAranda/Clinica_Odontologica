package com.dh.clinicaCountry;



import com.dh.clinicaCountry.model.Domicilio;
import com.dh.clinicaCountry.model.Paciente;
import com.dh.clinicaCountry.service.DomicilioService;
import com.dh.clinicaCountry.service.PacienteService;

import org.junit.Assert;


import org.junit.FixMethodOrder;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("calle 67 ", "122", "colina", "Bogota");
        Paciente p = pacienteService.guardar(new Paciente("Pedro", "Narvaez", "12345678", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Carrera", "122", "Unicentro", "bogota");
        Paciente p1 = pacienteService.guardar(new Paciente("Daniela", "Rodriguez", "09876543", new Date(), domicilio1));
    }

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Calle", "125", "Santa Barbara", "Bogota");
        Paciente p = pacienteService.guardar(new Paciente("Simon", "Gonzalez", "23456789", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());
    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }


}
