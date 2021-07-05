package com.Mawe.ProjetoIntegrador.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {
	
	@NotEmpty (message = "Campo não pode estar vazio")
	private String nome;
	
	@NotNull (message = "Campo não pode estar vazio")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
