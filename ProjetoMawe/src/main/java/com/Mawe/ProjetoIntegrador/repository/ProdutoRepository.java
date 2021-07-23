
package com.Mawe.ProjetoIntegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mawe.ProjetoIntegrador.model.Produto;

/**
 * Estabelecer comunicação com dados (MySQL)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	/**
	 * Pesquisar os parâmetros dos atributos, que contenha os caracteres informados
	 * na aplicação
	 * 
	 * @Método findByAllNomeContaining localiza os dados solicitados na tabela
	 * @param descricao
	 * @return atributos do Model, onde os caracteres correspondem com os parametros
	 *         do atributo nome
	 */
	List<Produto> findAllByNomeContaining (String nome);
	
	/**
	 * Pesquisar os parâmetros dos atributos, que contenha os caracteres informados
	 * na aplicação
	 * 
	 * @Método findByAllDescricaoContaining localizar os dados solicitados na tabela
	 * @param descricao
	 * @return atributos do Model, onde os caracteres correspondem com os parametros
	 *         do atributo descricao
	 */
	List<Produto> findAllByDescricaoContaining (String descricao);
	
	/**
	 * Pesquisar os parâmetros dos atributos, que contenha os caracteres informados
	 * na aplicação
	 * 
	 * @Método findByAllPrecoContaining localizar os dados solicitados na tabela
	 * @param preco
	 * @return atributos do Model, onde os caracteres correspondem com os parametros
	 *         do atributo preco
	 */
	List<Produto> findAllByPrecoContaining (Double preco);
