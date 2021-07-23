
package com.Mawe.ProjetoIntegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@NotNull (message = "é necessário informar o segmento da empresa correta")
	private TipoCategoria segmentoEmpresa;

	/**
	 * Valor de material reciclado reutilizado calculado por cubo do produto.
	 */
	@NotNull (message = "é necessário informar o valor de material reutilizado")
	private Double materialReutilizado;

	/**
	 * Valor de materiais biodegradáveis calculado por cubo do produto.
	 */
	@NotNull (message = "é necessário informar o valor de material biodegradavel")
	private Double materialBiodegradavel;
	
	/**
	 * Lista atributos de Produto
	 */
	@OneToMany(mappedBy = "categoria")
	@JsonIgnoreProperties ({"categoria", "empresaCriadora"})
	private List<Produto> produto;

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

	public Double getMaterialReutilizado() {
		return materialReutilizado;
	}

	public void setMaterialReutilizado(Double materialReutilizado) {
		this.materialReutilizado = materialReutilizado;
	}

	public Double getMaterialBiodegradavel() {
		return materialBiodegradavel;
	}

	public void setMaterialBiodegradavel(Double materialBiodegradavel) {
		this.materialBiodegradavel = materialBiodegradavel;
	}
