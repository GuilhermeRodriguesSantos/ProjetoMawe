package com.Mawe.ProjetoIntegrador.DTO;

import javax.validation.constraints.NotEmpty;

public class UsuarioLoginDTO {
	
	private long id;
	private String nome;
	
	@NotEmpty (message = "Campo não pode estar vazio")
	private String email;
	
	@NotEmpty (message = "Campo não pode estar vazio")
	private String senha;
	private String tipoUsuario;
	private String token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
