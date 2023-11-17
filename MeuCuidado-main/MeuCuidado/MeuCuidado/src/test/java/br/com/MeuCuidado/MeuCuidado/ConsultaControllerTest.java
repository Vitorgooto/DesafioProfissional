package br.com.MeuCuidado.MeuCuidado;

import br.com.MeuCuidado.MeuCuidado.controller.ConsultaController;
import br.com.MeuCuidado.MeuCuidado.model.Consulta;
import br.com.MeuCuidado.MeuCuidado.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ConsultaControllerTest {

    @Mock
    private ConsultaService consultaService;

    @InjectMocks
    private ConsultaController consultaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(consultaController).build();
    }

    @Test
    void getAllConsultas() throws Exception {
        Consulta consulta1 = new Consulta("1", "Paciente1", new Date(1637208000000L)); // 18/11/2023
        Consulta consulta2 = new Consulta("2", "Paciente2", new Date(1637294400000L)); // 19/11/2023

        when(consultaService.getAllConsultas()).thenReturn(Arrays.asList(consulta1, consulta2));

        mockMvc.perform(get("/consultas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].paciente").value("Paciente1"))
                // ... verificar outros atributos
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].paciente").value("Paciente2"));

        verify(consultaService, times(1)).getAllConsultas();
    }

    @Test
    void getConsultaById() throws Exception {
        Consulta consulta = new Consulta("1", "Paciente1", new Date(1637208000000L)); // 18/11/2023

        when(consultaService.getConsultaById("1")).thenReturn(Optional.of(consulta));

        mockMvc.perform(get("/consultas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.paciente").value("Paciente1"));

        verify(consultaService, times(1)).getConsultaById("1");
    }

    @Test
    void saveConsulta() throws Exception {
        Consulta consulta = new Consulta("1", "Paciente1", new Date(1637208000000L)); // 18/11/2023
        consulta.setId("1");

        when(consultaService.saveConsulta(any(Consulta.class))).thenReturn(consulta);

        mockMvc.perform(post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(consulta)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));

        verify(consultaService, times(1)).saveConsulta(any(Consulta.class));
    }

    @Test
    void deleteConsulta() throws Exception {
        mockMvc.perform(delete("/consultas/1"))
                .andExpect(status().isOk());

        verify(consultaService, times(1)).deleteConsulta("1");
    }
}
