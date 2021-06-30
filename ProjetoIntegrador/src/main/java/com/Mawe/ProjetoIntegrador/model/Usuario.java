package com.Mawe.ProjetoIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	/**
	 * Determinando os atributos da tabela Usuario
	 * 
	 * @since 1.0
	 * @author Guilherme
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 10)
	private String nome;

	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 10)
	private String email;

	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 10)
	private String senha;

	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 10)
	private String tipoUsuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
