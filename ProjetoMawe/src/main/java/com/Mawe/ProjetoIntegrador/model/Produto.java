package com.Mawe.ProjetoIntegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Abstração e instanciação de objetos/recursos. Definindo os atributos da
 * tabela Produto, com seus tipos e restrições
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Atribui nome do produto que será adicionado na lista
	 */
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome prescisa conter caracteres")
	private String nome;

	/**
	 * Atribui valor de preço a algum produto adicionado
	 */
	@NotNull(message = "Acrescentar o preço é obrigatório")
	private Float preco;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome prescisa conter caracteres")
	private String descricao;

	/**
	 * Permite adicionar quantidade de produto
	 */
	@NotNull(message = "A quantidade de produtos não pode ser nula")
	private Integer quantidade;
	
	/**
	 * Atributo que adiciona url(caminho) da foto de algum produto
	 */
	@NotEmpty(message = "Esse campo precisa ter a url da foto")
	private String url;
	
	/**
	 * Este parâmetro, que descende da tabela
	 Categoria, relaciona muito produtos para uma categoria 
	 */
	@ManyToOne
	@JsonIgnoreProperties ({"produtosCadastrados", "produto", "usuariosCompradores"})
	@NotNull (message = "É obrigatório informar a categoria do produto")
	private Categoria categoria;
	
	/**
	 * Este parâmetro, que descende da tabela
	 Usuario, relaciona muito produtos para um usuario
	 */
	//alterado
	@ManyToOne
	private Usuario empresaCriadora;
	
	/**
	 * Este parâmetro relaciona uma lista de usuariosCompradores
	 a muitos produtos 
	 */
	//alterado
	@ManyToMany
	private List<Usuario> usuariosCompradores;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Métodos Getters e Setters da relação entre tabelas
	 */
	public Usuario getEmpresaCriadora() {
		return empresaCriadora;
	}

	public void setEmpresaCriadora(Usuario empresaCriadora) {
		this.empresaCriadora = empresaCriadora;
	}

	public List<Usuario> getUsuariosCompradores() {
		return usuariosCompradores;
	}

	public void setUsuariosCompradores(List<Usuario> usuariosCompradores) {
		this.usuariosCompradores = usuariosCompradores;
	}
}
