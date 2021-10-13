package com.dh.clinicaCountry;

import com.dh.clinicaCountry.model.Dentista;
import com.dh.clinicaCountry.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionDentistaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles="ADMIN")
    public void registrarDentista() throws Exception {
        Dentista od = new Dentista( "Diego","Bernal",54321);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/dentistas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(od)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse()).getContentAsString().isEmpty());
    }

    @Test
    public void listarDentista() throws Exception {
        this.registrarDentista();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/dentistas/{id}",1)
        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse()).getContentAsString().isEmpty());
    }



}
