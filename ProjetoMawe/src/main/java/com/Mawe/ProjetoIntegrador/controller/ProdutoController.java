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

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping("/buscar")
	public ResponseEntity<List<Produto>> BuscarProduto() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("/buscar/nome")
	public ResponseEntity<List<Produto>> BuscarNome(@RequestParam String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	@GetMapping("/buscar/descricao")
	public ResponseEntity<List<Produto>> BuscarDescricao(@RequestParam String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}

	@GetMapping("/buscar/preco")
	public ResponseEntity<List<Produto>> BuscarPreco(@RequestParam Double preco) {
		return ResponseEntity.status(200).body(repository.findAllByPrecoContaining(preco));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Produto> BuscarId(@PathVariable long id) {
		return repository.findById(id).map(achou -> ResponseEntity.ok(achou)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Produto> Adicionar(@Valid @RequestBody Produto adicionar) {
		return ResponseEntity.status(201).body(repository.save(adicionar));
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<Produto> Alterar(@Valid @PathVariable Produto alterar) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(alterar));

	}

	@DeleteMapping("/delete/{id}")
	public void Deletar(@PathVariable long id) {
		repository.deleteById(id);
	}
}
