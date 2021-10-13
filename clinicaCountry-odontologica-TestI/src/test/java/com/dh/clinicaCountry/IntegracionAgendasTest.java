package com.dh.clinicaCountry;

import com.dh.clinicaCountry.model.Domicilio;
import com.dh.clinicaCountry.model.Dentista;
import com.dh.clinicaCountry.model.Paciente;
import com.dh.clinicaCountry.model.Agenda;
import com.dh.clinicaCountry.service.DentistaService;
import com.dh.clinicaCountry.service.PacienteService;
import com.dh.clinicaCountry.service.AgendaService;
import com.dh.clinicaCountry.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionAgendasTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DentistaService dentistaService;
    @Autowired
    private AgendaService agendaService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(roles="ADMIN")
    public void cargarDataSet() throws Exception {
        Domicilio domicilio = new Domicilio("calle 67 ", "122", "colina", "Bogota");
        Paciente p = pacienteService.guardar(new Paciente("Pedro", "Narvaez", "12345678", new Date(), domicilio));
        this.dentistaService.registrarDentista(new Dentista("Pedro", "Narvaez", 12345678));
        agendaService.registrarAgenda(new Agenda(pacienteService.buscar(1).get(), dentistaService.buscar(1).get(), new Date()));

    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void listarAgendas() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/Agendas").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}



