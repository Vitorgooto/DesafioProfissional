package br.com.MeuCuidado.MeuCuidado.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "consultas")
public class Consulta {
    @Id
    private String id;
    private String paciente;
    private Date dataConsulta;
    private String status;

    public Consulta(String id, String paciente, Date dataConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
    }

    public Consulta() {
    }

    public String getId() {
        return id;
    }

    public String getPaciente() {
        return paciente;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}