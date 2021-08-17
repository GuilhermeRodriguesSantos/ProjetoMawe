
package com.Mawe.ProjetoIntegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Mawe.ProjetoIntegrador.model.util.TipoCategoria;
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
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * O que diferencia o usuário padrão de uma empresa
	 * pensar no enumerated
	 */
	@Enumerated (EnumType.STRING)
	//@NotNull (message = "é necessário informar o segmento da empresa correta")
	private TipoCategoria segmentoEmpresa;

	/**
	 * Tipos de material reciclado que são reutilizados nos produtos.
	 */

	//@NotNull (message = "é necessário informar o valor de material reutilizado")
	private String materialReutilizado;

	/**
	 * Quantidade em porcentagem, dos materiais utilizados biodegradáveis e reutilizado.
	 */

	//@NotNull (message = "é necessário informar o valor de material biodegradavel")
	private String materialBiodegradavel;
	
	/**
	 * Lista atributos de Produto
	 */
	@OneToMany(mappedBy = "categoria")
	@JsonIgnoreProperties ({"categoria", "empresaCriadora", "produtosCadastrados"})
	private List<Produto> produto;

	@ManyToOne
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoCategoria getSegmentoEmpresa() {
		return segmentoEmpresa;
	}

	public void setSegmentoEmpresa(TipoCategoria segmentoEmpresa) {
		this.segmentoEmpresa = segmentoEmpresa;
	}

	public String getMaterialReutilizado() {
		return materialReutilizado;
	}

	public void setMaterialReutilizado(String materialReutilizado) {
		this.materialReutilizado = materialReutilizado;
	}

	public String getMaterialBiodegradavel() {
		return materialBiodegradavel;
	}

	public void setMaterialBiodegradavel(String materialBiodegradavel) {
		this.materialBiodegradavel = materialBiodegradavel;
	}
}