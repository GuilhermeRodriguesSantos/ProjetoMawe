package com.Mawe.ProjetoIntegrador.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {


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

