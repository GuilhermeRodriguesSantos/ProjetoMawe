package com.Mawe.ProjetoIntegrador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mawe.ProjetoIntegrador.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByCategoriaSustentavel(String categoriaSustentavel);

	List<Categoria> findAllByCategoriaSustentavelContaining(String categoriaSustentavel);
	List<Categoria> findAllByCategoriaDoacaoContaining(String categoriaDoacao);
}
