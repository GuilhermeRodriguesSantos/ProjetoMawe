package com.Mawe.ProjetoIntegrador.controller;

import java.util.List;
import java.util.Optional;

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

import com.Mawe.ProjetoIntegrador.DTO.CategoriaDTO;
import com.Mawe.ProjetoIntegrador.model.Categoria;
import com.Mawe.ProjetoIntegrador.repository.CategoriaRepository;
import com.Mawe.ProjetoIntegrador.service.CategoriaService;

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
	@Autowired
	private CategoriaService categoriaservice;

	/**
	 * Através do método HTTP, localiza todos os produtos
	 * 
	 * @NomeMétodo getAll
	 * @return para a aplicação: status e info no corpo da requisição
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
	 * Pesquisar os parametros da model, conforme a busca específica no atributo
	 * categoriaSustentavel
	 * 
	 * @param buscarcategoria
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscarcategoriasustentavel")
	public ResponseEntity<List<Categoria>> buscarcategoria(
			@RequestParam(defaultValue = "") String categoriaSustentavel) {
		return ResponseEntity.status(200)
				.body(categoriarepository.findAllByCategoriaSustentavelContaining(categoriaSustentavel));
	}

	/**
	 * Pesquisar os parametros da model, conforme a busca específica no atributo
	 * categoriaDoacao
	 * 
	 * @param buscarcategoria
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscarcategoriadoacao")
	public ResponseEntity<List<Categoria>> buscarcategoria2(@RequestParam(defaultValue = "") String categoriaDoacao) {
		return ResponseEntity.status(200).body(categoriarepository.findAllByCategoriaDoacaoContaining(categoriaDoacao));
	}

	/**
	 * Pesquisar a categoria conforme o id especificado na url
	 * 
	 * @NomeMetodo buscarpeloid
	 * @param id, atributo da classe Categoria
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/{id}/buscarpeloid")
	public ResponseEntity<Categoria> buscarpeloid(@PathVariable Long id) {
		return categoriarepository.findById(id).map(achou -> ResponseEntity.ok(achou))
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Adicionar parametros aos atributos da classe CategoriaModel
	 * 
	 * @PostMapping (Método HTTP), adicionar dados através do instanciamento de um
	 *              objeto (param)
	 * @NomeMetodo: adicionar
	 * @param novacategoria, Objeto instânciado para transportar informações
	 * @return status 201 e infs requisitadas pelo body
	 */
	@PostMapping("/adicionar")
	public ResponseEntity<Object> adicionar(@Valid @RequestBody Categoria novacategoria) {
		Optional<Object> categoria = categoriaservice.adicionar(novacategoria);
		if (categoria.isEmpty()) {
			return ResponseEntity.status(200).body("categoria existente");
		} else {
			return ResponseEntity.status(201).body("categoria cadastrada");
		}
	}

	/**
	 * Alteração de parametros, dos atributos da tabela Categoria
	 * 
	 * @NomeMetodo alterar
	 * @param novacategoria, Objeto instânciado para transportar informações
	 * @return retorna com infs no corpo da requisição, 
	 * 		save: salva as infos retornadas no corpo da requisição
	 */
	@PutMapping("/{id}/alterar")
	public ResponseEntity<Categoria> alterar(@Valid @PathVariable Long id,
			@Valid @RequestBody CategoriaDTO novacategoria) {
		return categoriaservice.alterar(id, novacategoria)
				.map(novacategoria1 -> ResponseEntity.status(201).body(novacategoria1)).orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
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