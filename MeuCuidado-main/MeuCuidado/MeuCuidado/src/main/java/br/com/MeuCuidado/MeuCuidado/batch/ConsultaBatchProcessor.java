package br.com.MeuCuidado.MeuCuidado.batch;

import br.com.MeuCuidado.MeuCuidado.model.Consulta;
import br.com.MeuCuidado.MeuCuidado.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ConsultaBatchProcessor {

    private final LinkedList<Consulta> fifoQueue = new LinkedList<>();

    @Autowired
    private ConsultaService consultaService;

    public void processBatch() {
        while (!fifoQueue.isEmpty()) {
            Consulta consulta = fifoQueue.removeFirst();
            if (consulta != null) {
                // Lógica de processamento em lote
                // Atualização no banco de dados (exemplo: marcar consulta como processada)
                consulta.setStatus("Processada");
                consultaService.saveConsulta(consulta);
            }

        }
    }
}
