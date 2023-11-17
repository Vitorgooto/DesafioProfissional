package br.com.MeuCuidado.MeuCuidado.repository;


import br.com.MeuCuidado.MeuCuidado.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {


}