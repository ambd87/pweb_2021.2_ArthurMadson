package br.com.arthur.cadclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arthur.cadclientes.model.cliente;

@Repository
public interface clienteRepository extends JpaRepository<cliente, Long> {

}