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

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome prescisa conter caracteres")
	private String nome;

	@NotNull(message = "O preço é obrigatório seu mané")
	private Float preco;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome prescisa conter caracteres")
	private String descricao;

	@NotNull(message = "O nome não pode ser nulo")
	private Integer quantidade;
	
	@NotEmpty(message = "Esse campo precisa ter a url da foto")
	private String url;
	
	@ManyToOne
	@JsonIgnoreProperties ({"produtosCadastrados", "produto", "usuariosCompradores"})
	@NotNull (message = "É obrigatório informar a categoria do produto")
	private Categoria categoria;

	//alterado
	@ManyToOne
	private Usuario empresaCriadora;
	
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
