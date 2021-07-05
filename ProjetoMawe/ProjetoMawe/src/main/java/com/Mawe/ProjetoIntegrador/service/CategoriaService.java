package com.Mawe.ProjetoIntegrador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mawe.ProjetoIntegrador.DTO.CategoriaDTO;
import com.Mawe.ProjetoIntegrador.model.Categoria;
import com.Mawe.ProjetoIntegrador.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriarepository;
	/**
	 * 
	 * @param novacategoria
	 * @return optional retorna vazio ou uma categoria salva
	 * @since 1.0
	 * @author Gustavo Moraes
	 */
	
	public Optional<Object> adicionar(Categoria novacategoria){
		return categoriarepository.findByCategoriaSustentavel(novacategoria.getCategoriaSustentavel()).
				map(categoriaexistente->{
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(categoriarepository.save(novacategoria));
		});
	}
	/**Alterando uma Categoria
	 * 
	 * @param id
	 * @param novacategoria
	 * @return Retorna uma catergoria atualizada, ou um Op vazio.
	 * @since 1.0
	 * @author Vinícius
	 */
	public Optional<Categoria> alterar(Long id,CategoriaDTO novacategoria){
		return categoriarepository.findById(id).map(atualizar-> {
			atualizar.setCategoriaRanking(novacategoria.getCategoriaRanking());
			atualizar.setCategoriaDoacao(novacategoria.getCategoriaDoacao());
			return Optional.ofNullable(categoriarepository.save(atualizar));
			
		}).orElseGet(()->{
			return Optional.empty();
		});
	}
}
