package com.gerenciador.financeiro.transporte.carga.pojo;

import java.math.BigDecimal;

public class Veiculo {
	
	private Integer codigo;
	private String nome;
	private BigDecimal fator;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getFator() {
		return fator;
	}
	public void setFator(BigDecimal fator) {
		this.fator = fator;
	}
}
