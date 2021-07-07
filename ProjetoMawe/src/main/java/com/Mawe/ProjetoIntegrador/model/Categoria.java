package com.Mawe.ProjetoIntegrador.model;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Abstração e instanciação de objetos/recursos. Definindo os atributos da
 * tabela Produto, com seus tipos e restrições
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@Entity
@Table(name = "tb_categoria")
public class Categoria {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 5)
	private String categoriaSustentavel;

	private int categoriaRanking;

	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 5)
	private String categoriaDoacao;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> produto;

	// Métodos Getters e Setters
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoriaSustentavel() {
		return categoriaSustentavel;
	}

	public void setCategoriaSustentavel(String categoriaSustentavel) {
		this.categoriaSustentavel = categoriaSustentavel;
	}

	public int getCategoriaRanking() {
		return categoriaRanking;
	}

	public void setCategoriaRanking(int categoriaRanking) {
		this.categoriaRanking = categoriaRanking;
	}

	public String getCategoriaDoacao() {
		return categoriaDoacao;
	}

	public void setCategoriaDoacao(String categoriaDoacao) {
		this.categoriaDoacao = categoriaDoacao;
	}

}