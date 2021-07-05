package com.Mawe.ProjetoIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * Definindo os atributos da tabela Produto, com seus tipos e restrições
 * @version 1.0
 * @since 1.0
 * @author Guilherme
 *
 */

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome prescisa conter caracteres")
	private String nome;

	@NotEmpty(message = "O preço é obrigatório seu mané")
	private double preco;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome prescisa conter caracteres")
	private String descricao;

	@NotNull(message = "O nome não pode ser nulo")
	private int quantidade;
	
	@NotEmpty(message = "Esse campo precisa ter a url da foto")
	private String url;
	
	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Usuario usuario;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
