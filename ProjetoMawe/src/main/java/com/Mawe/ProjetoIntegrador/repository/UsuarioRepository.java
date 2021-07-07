package com.Mawe.ProjetoIntegrador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mawe.ProjetoIntegrador.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario>findAllByNomeContaining(String nome);
	List<Usuario>findAllByEmailContaining(String email);
	Optional<Usuario>findById(long id);

}
