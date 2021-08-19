package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Mawe.ProjetoIntegrador.DTO.UsuarioDTO;
import com.Mawe.ProjetoIntegrador.DTO.UsuarioLoginDTO;
import com.Mawe.ProjetoIntegrador.model.Produto;
import com.Mawe.ProjetoIntegrador.model.Usuario;
import com.Mawe.ProjetoIntegrador.repository.UsuarioRepository;
import com.Mawe.ProjetoIntegrador.service.UsuarioService;

@RestController
@RequestMapping("/ProjetoMawe/Usuario/")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioRepository repository;
	
	/**
	 * Este metodo é responsável por cadastrar novoUsuario
	 * 
	 * @nomeobjeto CadastrarUsuario()
	 * @param Valida e busca no corpo do objeto novoUsuario
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição como
	 um usuario existente ou criado
	 */
	@PostMapping("Cadastrar")
	public ResponseEntity<Object> CadastrarUsuario(@RequestBody @Valid Usuario novoUsuario) {
		Optional<Object> produto = service.CadastrarUsuario(novoUsuario);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(201).body(service.CadastrarUsuario(novoUsuario));
		}
	}
	
	/**
	 * Este metodo é reponsável por alterar o parâmetro dadosLogar
	 * 
	 * @nomeobjeto Logar()
	 * @param Valida e busca em dadosLogar
	 * @return Para a aplicação: É mapeado no usuarioCredencial um dado e respondido um status de logado
	 ou uma má requisição
	 */
	@PostMapping("Logar")
	public ResponseEntity<?> Logar(@Valid @RequestBody UsuarioLoginDTO dadosLogar) {
		return service.Logar(dadosLogar).map(usuarioCredencial -> ResponseEntity.ok(usuarioCredencial))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	/**
	 * Este metodo é responsável por alterar o id do produto
	 * 
	 * @nomeobjeto alterar()
	 * @param Valida e reconhece o parametro id alterar
	 * @return Para aplicação: Retorna o status e as informações no corpo da requisição e salva a alteração, conforme o id indicado
	 feita pelo id
	 */
	@PutMapping("Alterar/{id}")
	public ResponseEntity<Usuario> alterar(@Valid @PathVariable Long id, @Valid @RequestBody UsuarioDTO novoUsuario) {
		return service.alterar(id, novoUsuario).map(usuarioNovo -> ResponseEntity.status(201).body(usuarioNovo))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}
	
	@PutMapping("/Alterar2")
	public ResponseEntity<Usuario> alterar2(@Valid @RequestBody Usuario usuarioParaAlterar){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCriptografada = encoder.encode(usuarioParaAlterar.getSenha());
		usuarioParaAlterar.setSenha(senhaCriptografada);
		return ResponseEntity.status(201).body(repository.save(usuarioParaAlterar));
	}
	
	/**
	 * Este metodo é responsável por deletar o id do produto
	 * 
	 * @nomeobjeto Deletar() 
	 * @param Deleta o parametro id 
	 */
	@DeleteMapping("Deletar/{id}")
	public void DeletarUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Este metodo busca o Usuario pela lista
	 * 
	 * @nomeobjeto Buscar()
	 * @return Para aplicação: Retorna o status e as informações no corpo da requisição
	 */
	@GetMapping("Buscar")
	public ResponseEntity<List<Usuario>> Buscar() {
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	/**
	 * Este metodo busca pelo nome do Usuario, através do parametro nome
	 * 
	 * @nomeobjeto BuscarNome()
	 * @param Faz a requisição do parametro nome
	 * @return Retorna o status e as informações no corpo da requisição, conforme o nome informado
	 */
	@GetMapping("Buscar/nome")
	public ResponseEntity<List<Usuario>> BuscarNome(@RequestParam String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}
	
	/**
	 * Este metodo busca parâmetros da classe Usuario, conforme o email informado
	 * 
	 * @nomeobjeto BuscarEmail()
	 * @param Faz a requisição do parametro email
	 * @return Retorna o status e as informações no corpo da requisição, conforme o email informado
	 */
	@GetMapping("Buscar/email")
	public ResponseEntity<List<Usuario>> BuscarEmail(@RequestParam String email) {
		return ResponseEntity.status(200).body(repository.findAllByEmailContaining(email));
	}
	
	/**
	 * Este metodo também pesquisa parâmetros da classe de Usuario, conforme o id informado
	 * 
	 * @nomeobjeto BuscarId()
	 * @param Request: long id
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição, conforme o id indicado
	 */
	@GetMapping("Buscar/{id}")
	public ResponseEntity<Usuario> BuscarId(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
}