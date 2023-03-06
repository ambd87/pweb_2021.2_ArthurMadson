package br.com.arthur.cadpessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository 
	
		extends jpaRepository<Pessoa, Long>{
			
			
			
		}
			


	
