package com.pastor.projeto.model;

public enum TipoCarro {
	
	BASICO("Básico"), 
	COMPLETO("Completo");
	
	private String descricao;
	
	private TipoCarro(String descricao) {
      this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
