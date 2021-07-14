package com.Mawe.ProjetoIntegrador.DTO;

import javax.validation.constraints.NotEmpty;

import com.Mawe.ProjetoIntegrador.model.util.TipoUsuario;

public class UsuarioLoginDTO {
	
	private long id;
	private String nome;
	
	@NotEmpty (message = "Campo não pode estar vazio")
	private String email;
	
	@NotEmpty (message = "Campo não pode estar vazio")
	private String senha;
	private TipoUsuario tipoUsuario;
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

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
