
package com.Mawe.ProjetoIntegrador.DTO;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {
	
	private int categoriaRanking;
	@NotEmpty(message = "Não pode ser nulo!")
	private String categoriaDoacao;
	
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

