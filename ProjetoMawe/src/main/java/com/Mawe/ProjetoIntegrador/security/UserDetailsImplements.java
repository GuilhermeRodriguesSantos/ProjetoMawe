package com.Mawe.ProjetoIntegrador.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Mawe.ProjetoIntegrador.model.Usuario;

public class UserDetailsImplements implements UserDetails{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Este atributo email é usado para a autorização de segurança
	 */
	private String email;
	/**
	 * Este atributo senha é usado para a autorização de segurança
	 */
	private String senha;
	/**
	 * Traz atributos e metodos da classe GrantedAuthority
	 * 
	 * @param autorizações
	 */
	private List<GrantedAuthority> autorizacoes;


	public UserDetailsImplements(Usuario usuario) {
		super();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autorizacoes;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
