package br.com.arthur.cadclientes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 8128389568127787766L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long codigo;
	private String nome;
	private String apelido;
	private String endereco;
	private String bairro;
	private String municipio;
	private String telefone;
	private String email;
	private String cnpjcpf;
	private String cep;
	private String estado;
	private String celular;
	private String grupo;
	private String situacao;

}