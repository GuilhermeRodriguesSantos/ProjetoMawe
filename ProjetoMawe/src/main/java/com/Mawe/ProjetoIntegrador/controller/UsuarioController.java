
package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		Optional<Object> cadastro = service.CadastrarUsuario(novoUsuario);
		
		if (cadastro.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario Existente");
		} else {
			return ResponseEntity.status(201).body("Usuario Criado");
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
	@PutMapping("Logar")
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
	@PutMapping("alterar/{id}")
	public ResponseEntity<Usuario> alterar(@Valid @PathVariable Long id, @Valid @RequestBody UsuarioDTO novoUsuario) {
		return service.alterar(id, novoUsuario).map(usuarioNovo -> ResponseEntity.status(201).body(usuarioNovo))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}
	
	/**
	 * Este metodo é responsável por deletar o id do produto
	 * 
	 * @nomeobjeto Deletar() 
	 * @param Deleta o parametro id 
	 */
	@DeleteMapping("deletar/{id}")
	public void DeletarUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Este metodo busca o Usuario pela lista
	 * 
	 * @nomeobjeto Buscar()
	 * @return Para aplicação: Retorna o status e as informações no corpo da requisição
	 */
	@GetMapping("buscar")
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
	@GetMapping("buscar/nome")
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
	@GetMapping("buscar/email")
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
	@GetMapping("buscar/{id}")
	public ResponseEntity<Usuario> BuscarId(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	/**
	 * Este metodo cria um produto quando o Usuário é Empresa. (tipoUsuario)
	 * @param id ou tipoUsuario
	 * @param novoProduto
	 * @return
	 */
	@PostMapping("/{id_usuario}/novo/produto")
	public ResponseEntity<?> cadastrarProduto(
			@PathVariable(value = "id_usuario") Long id,
			@Valid @RequestBody Produto novoProduto){
		Optional<Produto> produtoCriado = service.criarProduto(novoProduto, id, novoProduto.getCategoria());
		if (!produtoCriado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado.get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não é uma empresa, então ele não pode criar um produto");
		}
	}

}
