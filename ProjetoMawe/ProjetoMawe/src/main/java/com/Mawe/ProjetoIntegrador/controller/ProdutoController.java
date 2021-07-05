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

import com.Mawe.ProjetoIntegrador.model.Produto;
import com.Mawe.ProjetoIntegrador.repository.ProdutoRepository;

/**
 * Manipular requisições de fora da API (através do mét HTTP)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

	/**
	 * Fazer vínculo com a ProdutoRepository
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param repository
	 */
	@Autowired
	private ProdutoRepository repository;

	/**
	 * Através do método HTTP, localiza todos os produtos
	 * 
	 * @NomeMétodo BuscarProduto
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscar")
	public ResponseEntity<List<Produto>> BuscarProduto() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	/**
	 * Através do método HTTP, busca todos parametros que contém um caracter
	 * solicitado
	 * 
	 * @param nome
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscar/nome")
	public ResponseEntity<List<Produto>> BuscarNome(@RequestParam String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	/**
	 * Através do método HTTP, busca todos parametros que contém um caracter
	 * solicitado
	 * 
	 * @param descricao
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscar/descricao")
	public ResponseEntity<List<Produto>> BuscarDescricao(@RequestParam String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}

	/**
	 * Através do método HTTP, busca todos parametros que contém um caracter
	 * solicitado
	 * 
	 * @param preco
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscar/preco")
	public ResponseEntity<List<Produto>> BuscarPreco(@RequestParam Double preco) {
		return ResponseEntity.status(200).body(repository.findAllByPrecoContaining(preco));
	}

	/**
	 * Retorna do banco de dados a linha especificada pelo @id, informado no método
	 * HTTP
	 * 
	 * @param id, atributo da classe Produto
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Produto> BuscarId(@PathVariable long id) {
		return repository.findById(id).map(achou -> ResponseEntity.ok(achou)).orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Adicionar parametros aos atributos da classe Produto
	 * 
	 * @param adicionar
	 * @return Através do método HTTP
	 */
	@PostMapping("/adicionar")
	public ResponseEntity<Produto> Adicionar(@Valid @RequestBody Produto adicionar) {
		return ResponseEntity.status(201).body(repository.save(adicionar));
	}

	/**
	 * Alteração de parametros, dos atributos da tabela Produto
	 * 
	 * @NomeMetodo Alterar
	 * @param alterar, Objeto instânciado para transportar informações
	 * @return utiliza em conjuto com uma aplicação alteracao: retorna com infs no
	 *         corpo da requisição save: salva as infos retornadas no corpo da
	 *         requisição
	 */
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Produto> Alterar(@Valid @PathVariable Produto alterar) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(alterar));
	}

	/**
	 * Deleta o conjunto de informações atreladas ao id (linha da tabela, no banco de dados)
	 * 
	 * @NomeMétodo Deletar
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
	public void Deletar(@PathVariable long id) {
		repository.deleteById(id);
	}
}