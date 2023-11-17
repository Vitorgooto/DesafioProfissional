package br.com.MeuCuidado.MeuCuidado.controller;

import br.com.MeuCuidado.MeuCuidado.model.Consulta;
import br.com.MeuCuidado.MeuCuidado.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    public Consulta getConsultaById(@PathVariable String id) {
        return consultaService.getConsultaById(id).orElse(null);
    }

    @PostMapping
    public Consulta saveConsulta(@RequestBody Consulta consulta) {
        return consultaService.saveConsulta(consulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable String id) {
        consultaService.deleteConsulta(id);
    }
}