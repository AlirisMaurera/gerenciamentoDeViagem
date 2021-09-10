package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.repository;

import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Long> {
}
