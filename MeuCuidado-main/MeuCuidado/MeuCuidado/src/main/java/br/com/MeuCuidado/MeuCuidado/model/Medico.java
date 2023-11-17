package br.com.MeuCuidado.MeuCuidado.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nome;
    private String Especialidade;

    public Medico(Long id, String nome, String especialidade) {
        this.id = id;
        Nome = nome;
        Especialidade = especialidade;
    }

    public Medico() {
        // Construtor vazio necessário para frameworks como Spring Data JPA
    }

    public Medico(String Nome, String Especialidade) {
        this.Nome = Nome;
        this.Especialidade = Especialidade;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.Especialidade = Especialidade;
    }

    // Outros métodos, se necessário
}

