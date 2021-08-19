
package com.Mawe.ProjetoIntegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.Mawe.ProjetoIntegrador.model.util.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	/**
	 * Abstração e instanciação de objetos/recursos. Definindo os atributos da
	 * tabela Produto, com seus tipos e restrições
	 * 
	 * Última atualização: julho de 2021
	 * 
	 * @author desenvolvedores Mawé
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Este atributo permite o usuário acrescentar um nome
	 */
	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 5)
	private String nome;

	/**
	 *  Este atributo permite o usuário acrescentar um email
	 */
	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 5)
	@Email
	private String email;

	/**
	 *  Este atributo permite o usuário acrescentar uma senha
	 */
	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 5)
	private String senha;
	
	/**
	 * Este parâmetro tipoUsuario define se quem ira se cadastrar é EMPRESA ou USUARIO
	 através da classe de enumeração Enum
	 */
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario; 
	
	/**
	 *  Este atributo permite o usuário acrescentar um endereço
	 */
	@NotEmpty(message = "Não pode ser nulo!")
	@Size(min = 5)
	private String endereco;

	/**
	 * Este parâmetro, que descende da tabela
	 Produto, relaciona um usuário que poderá cadastrar muitos produtos
	 */

	@OneToMany (mappedBy = "empresaCriadora")
	@JsonIgnoreProperties ({"empresaCriadora", "categoria", "produtosCadastrados"})
	private List<Produto> produtosCadastrados;
	
	/**
	 * Este parâmetro, que descende da tabela
	 Produto, relaciona muitos compradores a muitos produtos
	 */
	@ManyToMany (mappedBy = "usuariosCompradores")
	@JsonIgnoreProperties ({"empresaCriadora", "categoria", "produtosCadastrados"})
	private List<Produto> produtosComprados;
	
	/**	
	 * Este parâmetro, que descende da tabela
	 Categoria, relaciona muitos usuarios a uma categoria
	 */
	@OneToMany(mappedBy = "usuario")
	private List<Categoria> categoria;

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Produto> getProdutosCadastrados() {
		return produtosCadastrados;
	}

	public void setProdutosCadastrados(List<Produto> produtosCadastrados) {
		this.produtosCadastrados = produtosCadastrados;
	}

	public List<Produto> getProdutosComprados() {
		return produtosComprados;
	}

	public void setProdutosComprados(List<Produto> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
