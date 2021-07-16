package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mawe.ProjetoIntegrador.model.Categoria;
import com.Mawe.ProjetoIntegrador.repository.CategoriaRepository;

/**
 * Manipular requisições de fora da API (através do mét HTTP)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	/**
	 * Fazer vínculo com a CategoriaRepository
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param categoriarepository
	 */
	@Autowired
	private CategoriaRepository categoriarepository;
	
	/**
	 * Fazer vínculo com a CategoriaService
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param categoriaservice
	 */
	
	@GetMapping("/buscartodos")
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> categoria = categoriarepository.findAll();

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
	@GetMapping("/{id}/buscarpeloid") 
	public ResponseEntity<Categoria> buscarpeloid(@PathVariable Long id){
		return categoriarepository.findById(id).map(achou-> ResponseEntity.ok(achou)).orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Deleta o conjunto de informações atreladas ao id (linha da tabela, no banco de dados)
	 * 
	 * @NomeMétodo deletar
	 * @param id
	 */
	@DeleteMapping("/{id}/deletar")
	public void deletar(@PathVariable Long id) {
	categoriarepository.deleteById(id);
	}
	
}	