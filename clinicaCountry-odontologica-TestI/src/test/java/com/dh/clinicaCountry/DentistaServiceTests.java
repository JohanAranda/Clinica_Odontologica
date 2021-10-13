package com.dh.clinicaCountry;

import com.dh.clinicaCountry.model.Dentista;
import com.dh.clinicaCountry.service.dentistaService;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistaServiceTests {
    @Autowired
    private DentistaService dentistaService;


    public void cargarDataSet() {
        this.dentistaService.registrarDentista(new Dentista("Pedro", "Narvaez", 12345678));
    }

    @Test
    public void agregarDentista() {
        this.cargarDataSet();
        Dentista dentista = dentistaService.registrarDentista(new Dentista("Pedro", "Narvaez", 12345678));
        Assert.assertTrue(dentista.getId() != null);

    }

    @Test
    public void eliminarDentistaTest() {
        dentistaService.eliminar(1);
        Assert.assertTrue(dentistaService.buscar(1).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Dentista> Dentistas = dentistaService.buscarTodos();
        Assert.assertTrue(!dentistas.isEmpty());
        Assert.assertTrue(dentistas.size() == 1);
        System.out.println(dentistas);
    }

}
