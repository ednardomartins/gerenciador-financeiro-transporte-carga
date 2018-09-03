package com.gerenciador.financeiro.transporte.carga.cenario;

import java.math.BigDecimal;

public enum VeiculoEnum {
	CAMINHAO_BAU(1, "Caminhão baú",BigDecimal.valueOf(1.00).setScale(2, BigDecimal.ROUND_UP)),
	CAMINHAO_CACAMBA(2, "Caminhão caçamba",BigDecimal.valueOf(1.05).setScale(2, BigDecimal.ROUND_UP)),
	CARRETA(3, "Carreta",BigDecimal.valueOf(1.12).setScale(2, BigDecimal.ROUND_UP));
	
	private Integer codigo;
	private String nome;
	private BigDecimal fator;
	
	private VeiculoEnum(Integer codigo,String nome,BigDecimal fator) {
		this.codigo = codigo;
		this.nome = nome;
		this.fator = fator;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getFator() {
		return fator;
	}

}
