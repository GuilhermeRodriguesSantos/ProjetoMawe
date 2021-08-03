
package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Mawe.ProjetoIntegrador.model.Produto;
import com.Mawe.ProjetoIntegrador.repository.ProdutoRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrar (@RequestBody @Valid Produto novoProduto){
		return ResponseEntity.status(201).body(repository.save(novoProduto));
	}
	
	/**
	 * Este metodo pesquisa todos os parâmetros da classe de Produto
	 * 
	 * @nomeobjeto BuscarProduto()
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição
	 */
	@GetMapping("/buscar")
	public ResponseEntity<List<Produto>> BuscarProduto() {
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	/**
	 * Este metodo também pesquisa parâmetros da classe de Produto, conforme o nome informado 
	 * 
	 * @nomeobjeto BuscarNome()
	 * @param Request: String nome
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição, conforme o nome indicado
	 */
	@GetMapping("/buscar/nome")
	public ResponseEntity<List<Produto>> BuscarNome(@RequestParam String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}
	
	/**
	 * Este metodo também pesquisa parâmetros da classe de Produto, conforme a descrição informada
	 * 
	 * @nomeobjeto BuscarDescricao()
	 * @param Request: String descricao
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição, conforme alguma descrição indicada
	 */
	@GetMapping("/buscar/descricao")
	public ResponseEntity<List<Produto>> BuscarDescricao(@RequestParam String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}
	
	/**
	 * Este metodo também pesquisa parâmetros da classe de Produto, conforme o preço informado
	 * 
	 * @nomeobjeto BuscarPreco()
	 * @param Request: Double preco
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição, conforme o preço indicado
	 */
	@GetMapping("/buscar/preco")
	public ResponseEntity<List<Produto>> BuscarPreco(@RequestParam Double preco) {
		return ResponseEntity.status(200).body(repository.findAllByPrecoContaining(preco));
	}
	
	/**
	 * Este metodo também pesquisa parâmetros da classe de Produto, conforme o id informado
	 * 
	 * @nomeobjeto BuscarId()
	 * @param Request: long id
	 * @return Para a aplicação: Retorna o status e as informações no corpo da requisição, conforme o id indicado
	 */
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Produto> BuscarId(@PathVariable long id) {
		return repository.findById(id).map(achou -> ResponseEntity.ok(achou)).orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Descontinuado, devido criação de regra de negócio 
	@PostMapping("/adicionar")
	public ResponseEntity<Produto> Adicionar(@Valid @RequestBody Produto adicionar) {
		return ResponseEntity.status(201).body(repository.save(adicionar));
	}
	*/
	
	/**
	 * Este metodo é responsável por alterar o id do produto
	 * 
	 * @nomeobjeto Alterar()
	 * @param Valida e reconhece o parametro id alterar
	 * @return Para aplicação: Retorna o status e as informações no corpo da requisição e salva a alteração 
	 feita no id
	 */
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Produto> Alterar(@Valid @PathVariable Produto alterar) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(alterar));
	}
	
	/**
	 * Este metodo é responsável por deletar o id do produto
	 * 
	 * @nomeobjeto Deletar() 
	 * @param Deleta o parametro id 
	 */
	@DeleteMapping("/delete/{id}")
	public void Deletar(@PathVariable long id) {
		repository.deleteById(id);
	}
}

