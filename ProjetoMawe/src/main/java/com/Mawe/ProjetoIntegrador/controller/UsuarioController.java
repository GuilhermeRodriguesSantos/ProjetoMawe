package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.Mawe.ProjetoIntegrador.DTO.UsuarioLoginDTO;
import com.Mawe.ProjetoIntegrador.model.Usuario;
import com.Mawe.ProjetoIntegrador.repository.UsuarioRepository;
import com.Mawe.ProjetoIntegrador.service.UsuarioService;

@RestController
@RequestMapping("/ProjetoMawe/Usuario/")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioRepository repository;

	@PostMapping("Cadastrar")
	public ResponseEntity<Object> CadastrarUsuario(@RequestBody @Valid Usuario novoUsuario) {
		Optional<Object> cadastro = service.CadastrarUsuario(novoUsuario);

		if (cadastro.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario Existente");
		} else {
			return ResponseEntity.status(201).body("Usuario Criado");
		}
	}

	@PutMapping("Logar")
	public ResponseEntity<?> Logar(@Valid @RequestBody UsuarioLoginDTO dadosLogar) {
		return service.Logar(dadosLogar).map(usuarioCredencial -> ResponseEntity.ok(usuarioCredencial))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("alterar/{id}")
	public ResponseEntity<Usuario> alterar(@Valid @PathVariable long id, @Valid @RequestBody UsuarioDTO novoUsuario) {
		return service.alterar(id, novoUsuario).map(usuarioNovo -> ResponseEntity.status(201).body(usuarioNovo))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}

	@DeleteMapping("deletar/{id}")
	public void DeletarUsuario(@PathVariable long id) {
		repository.deleteById(id);
	}

	@GetMapping("buscar")
	public ResponseEntity<List<Usuario>> Buscar() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("buscar/nome")
	public ResponseEntity<List<Usuario>> BuscarNome(@RequestParam String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	@GetMapping("buscar/email")
	public ResponseEntity<List<Usuario>> BuscarEmail(@RequestParam String email) {
		return ResponseEntity.status(200).body(repository.findAllByEmailContaining(email));
	}

	@GetMapping("buscar/{id}")
	public ResponseEntity<Usuario> BuscarId(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

}
