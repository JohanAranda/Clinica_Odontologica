package com.dh.clinicaCountry;

import com.dh.clinicaCountry.model.Domicilio;
import com.dh.clinicaCountry.model.Dentista;
import com.dh.clinicaCountry.model.Paciente;
import com.dh.clinicaCountry.model.Agenda;
import com.dh.clinicaCountry.service.DentistaService;
import com.dh.clinicaCountry.service.PacienteService;
import com.dh.clinicaCountry.service.AgendaService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DentistaService dentistaService;
    @Autowired
    private AgendaService agendaService;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("calle 67 ", "122", "colina", "Bogota");
        Paciente p = pacienteService.guardar(new Paciente("Pedro", "Narvaez", "12345678", new Date(), domicilio));
        this.dentistaService.registrarDentista(new Dentista("Pedro", "Narvaez",12345678));
    }
    @Test
    public void altaAgendaTest(){
        this.cargarDataSet();
        agendaService.registrarAgenda(new Agenda(pacienteService.buscar(1).get(),dentistaService.buscar(1).get(),new Date()));
        Assert.assertNotNull(agendaService.buscar(1));
    }
    @Test
    public void buscarAgendaTest(){
        Assert.assertNotNull(agendaService.buscar(1));
    }
    @Test
    public void eliminarAgendaTest(){
        agendaService.eliminar(1);
        Assert.assertFalse(agendaService.buscar(1).isPresent());
    }
}
