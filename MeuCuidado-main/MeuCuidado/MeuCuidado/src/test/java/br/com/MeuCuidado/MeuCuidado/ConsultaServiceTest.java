package br.com.MeuCuidado.MeuCuidado;

import br.com.MeuCuidado.MeuCuidado.model.Consulta;
import br.com.MeuCuidado.MeuCuidado.repository.ConsultaRepository;
import br.com.MeuCuidado.MeuCuidado.service.ConsultaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ConsultaServiceTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private ConsultaService consultaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllConsultas() {
        Consulta consulta1 = new Consulta("1", "Paciente1", new Date(1637208000000L)); // 18/11/2023
        Consulta consulta2 = new Consulta("2", "Paciente2", new Date(1637294400000L)); // 19/11/2023

        when(consultaRepository.findAll()).thenReturn(Arrays.asList(consulta1, consulta2));

        List<Consulta> consultas = consultaService.getAllConsultas();

        assertEquals(2, consultas.size());
        assertEquals("1", consultas.get(0).getId());
        assertEquals("Paciente1", consultas.get(0).getPaciente());
        // ... verificar outros atributos

        verify(consultaRepository, times(1)).findAll();
    }

    @Test
    void getConsultaById() {
        Consulta consulta = new Consulta("1", "Paciente1", new Date(1637208000000L)); // 18/11/2023

        when(consultaRepository.findById("1")).thenReturn(Optional.of(consulta));

        Optional<Consulta> consultaOptional = consultaService.getConsultaById("1");

        assertEquals(consulta, consultaOptional.orElse(null));
        verify(consultaRepository, times(1)).findById("1");
    }

    @Test
    void saveConsulta() {
        Consulta consulta = new Consulta("1", "Paciente1", new Date(1637208000000L)); // 18/11/2023

        when(consultaRepository.save(consulta)).thenReturn(consulta);

        Consulta savedConsulta = consultaService.saveConsulta(consulta);

        assertEquals(consulta, savedConsulta);
        verify(consultaRepository, times(1)).save(consulta);
    }

    @Test
    void deleteConsulta() {
        consultaService.deleteConsulta("1");

        verify(consultaRepository, times(1)).deleteById("1");
    }
}
