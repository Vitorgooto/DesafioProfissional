package br.com.MeuCuidado.MeuCuidado.service;

import br.com.MeuCuidado.MeuCuidado.model.Consulta;
import br.com.MeuCuidado.MeuCuidado.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class ConsultaService {
    private final ConsultaRepository consultaRepository;


    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getConsultaById(String id) {
        return consultaRepository.findById(id);
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(String id) {
        consultaRepository.deleteById(id);
    }
}
