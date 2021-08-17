
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mawe.ProjetoIntegrador.model.Categoria;
import com.Mawe.ProjetoIntegrador.model.Produto;
import com.Mawe.ProjetoIntegrador.repository.CategoriaRepository;

/**
 * Manipular requisições de fora da API (através do mét HTTP)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {

	/**
	 * Fazer vínculo com a CategoriaRepository
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param categoriarepository
	 */
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/**
	 * Fazer vínculo com a CategoriaService
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param categoriaservice
	 */
	
	@GetMapping("/buscartodos")
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> categoria = categoriaRepository.findAll();

		if (categoria.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(categoria);
		}
	}
	
	/**
	 * Pesquisar a categoria conforme o id especificado na url
	 * 
	 * @NomeMetodo buscarpeloid
	 * @param id, atributo da classe Categoria
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("buscarpeloid/{id}") 
	public ResponseEntity<Categoria> buscarPeloId(@PathVariable Long id){
		return categoriaRepository.findById(id).map(achou-> ResponseEntity.ok(achou)).orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Deleta o conjunto de informações atreladas ao id (linha da tabela, no banco de dados)
	 * 
	 * @NomeMétodo deletar
	 * @param id
	 */
	@DeleteMapping("deletar/{id}")
	public void deletar(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
	
	@PostMapping("/Cadastrar")
	public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody Categoria novaCategoria){
		return ResponseEntity.status(201).body(categoriaRepository.save(novaCategoria));
	}
	
	@PutMapping("/Alterar")
	public ResponseEntity<Categoria> alterar(@Valid @RequestBody Categoria novaCategoria){
		return ResponseEntity.status(201).body(categoriaRepository.save(novaCategoria));
	}
	
}	
