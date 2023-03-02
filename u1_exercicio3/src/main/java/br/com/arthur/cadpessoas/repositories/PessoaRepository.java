package br.com.arthur.cadpessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
