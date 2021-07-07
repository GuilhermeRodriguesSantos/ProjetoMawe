package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Mawe.ProjetoIntegrador.DTO.UsuarioDTO;
import com.Mawe.ProjetoIntegrador.model.Usuario;
import com.Mawe.ProjetoIntegrador.repository.UsuarioRepository;
import com.Mawe.ProjetoIntegrador.service.UsuarioService;

/**
 * Manipular requisições de fora da API (através do mét HTTP)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	/**
	 * Fazer vínculo com a UsuarioService
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param service
	 */
	@Autowired
	private UsuarioService service;
	
	/**
	 * Fazer vínculo com a UsuarioRepository
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param repository
	 */
	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/buscar")
	public ResponseEntity<List<Usuario>> Buscar() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("/buscar/nome")
	public ResponseEntity<List<Usuario>> BuscarNome(@RequestParam String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	@GetMapping("/buscar/email")
	public ResponseEntity<List<Usuario>> BuscarEmail(@RequestParam String email) {
		return ResponseEntity.status(200).body(repository.findAllByEmailContaining(email));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Usuario> BuscarId(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<Usuario> alterar(@Valid @PathVariable long id, @Valid @RequestBody UsuarioDTO novoUsuario) {
		return service.alterar(id, novoUsuario).map(usuarioNovo -> ResponseEntity.status(201).body(usuarioNovo))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Usuario> AdicionarUsuario(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}

	@DeleteMapping("/deletar/{id}")
	public void DeletarUsuario(@PathVariable long id) {
		repository.deleteById(id);
	}

	/*
	 * Método Delete com retorno
	 * 
	 * import org.apache.catalina.connector.Response;
	 * 
	 * @DeleteMapping ("/deletar/{id}") public
	 * ResponseEntity<String>Deletar(@PathVariable long id){
	 * repository.deleteById(id); return
	 * ResponseEntity.status(204).body("deletado"); }
	 */
	
}