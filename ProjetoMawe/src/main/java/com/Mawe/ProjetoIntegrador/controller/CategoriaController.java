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

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@GetMapping("/buscartodos")
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> categoria = categoriarepository.findAll();

		if (categoria.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(categoria);
		}
	}
	@PostMapping("/adicionar")
	public ResponseEntity<Object> adicionar(@Valid @RequestBody Categoria novacategoria){
		Optional<Object> categoria = categoriaservice.adicionar(novacategoria);
		if (categoria.isEmpty()) {
			return ResponseEntity.status(200).body("categoria existente");
		}
		else {
			return ResponseEntity.status(201).body("categoria cadastrada");
		}
	} 
	@GetMapping("/buscarcategoriasustentavel")
	public ResponseEntity<List<Categoria>> buscarcategoria (@RequestParam (defaultValue = "")String categoriaSustentavel){
		return ResponseEntity.status(200).body(categoriarepository.findAllByCategoriaSustentavelContaining(categoriaSustentavel));
	}
	@GetMapping("/buscarcategoriadoacao")
	public ResponseEntity<List<Categoria>> buscarcategoria2 (@RequestParam (defaultValue = "")String categoriaDoacao){
		return ResponseEntity.status(200).body(categoriarepository.findAllByCategoriaDoacaoContaining(categoriaDoacao));
	}

	@GetMapping("/{id}/buscarpeloid") 
	public ResponseEntity<Categoria> buscarpeloid(@PathVariable Long id){
		return categoriarepository.findById(id).map(achou-> ResponseEntity.ok(achou)).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}/deletar")
	public void deletar(@PathVariable Long id) {
	categoriarepository.deleteById(id);
	}
	@PutMapping("/{id}/alterar")
	public ResponseEntity<Categoria> alterar(@Valid @PathVariable Long id,@Valid @RequestBody CategoriaDTO novacategoria){
		return categoriaservice.alterar(id, novacategoria).map(novacategoria1 -> ResponseEntity.status(201).body(novacategoria1))
				.orElseGet(()->{
					return ResponseEntity.badRequest().build();
				});
	}
}	
