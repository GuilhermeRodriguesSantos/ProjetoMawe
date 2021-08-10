
package com.Mawe.ProjetoIntegrador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mawe.ProjetoIntegrador.model.Categoria;

/**
 * Estabelecer comunicação com dados (MySQL)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findBySegmentoEmpresa (String segmentoEmpresa);

	List<Categoria> findAllByMaterialReutilizadoContaining(String materialReutilizado);
	List<Categoria> findAllByMaterialBiodegradavelContaining(String materialBiodegradavel);
}
