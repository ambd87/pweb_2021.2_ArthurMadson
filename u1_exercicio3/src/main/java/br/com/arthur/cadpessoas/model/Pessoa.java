package br.com.arthur.cadpessoas.model;

import java.io.Serialzable;
import java.time.LocalDate;

import java.persistence.Column;
import java.persistence.Entity;
import java.persistence.GeneratedValue;
import java.persistence.GenerationType;
import java.persistence.Id;
import java.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pessoas")

public class Pessoa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String email;
	private String genero;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
}
