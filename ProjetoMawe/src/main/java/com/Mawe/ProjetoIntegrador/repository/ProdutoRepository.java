package com.Mawe.ProjetoIntegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mawe.ProjetoIntegrador.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAllByNomeContaining (String nome);
	
	List<Produto> findAllByDescricaoContaining (String descricao);
	
	List<Produto> findAllByPrecoContaining (Double preco);
}
