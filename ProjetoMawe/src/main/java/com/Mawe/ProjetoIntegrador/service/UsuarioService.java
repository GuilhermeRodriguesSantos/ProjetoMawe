package com.Mawe.ProjetoIntegrador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mawe.ProjetoIntegrador.DTO.UsuarioDTO;
import com.Mawe.ProjetoIntegrador.model.Usuario;
import com.Mawe.ProjetoIntegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	public Optional<Usuario>alterar(long id, UsuarioDTO novoUsuario){
		return repository.findById(id).map(atualizarUsuario -> {
			atualizarUsuario.setNome(novoUsuario.getNome());
			atualizarUsuario.setSenha(novoUsuario.getSenha());
			return Optional.ofNullable(repository.save(atualizarUsuario));
		}).orElseGet(()->{
			return Optional.empty();
		});
	}

}
