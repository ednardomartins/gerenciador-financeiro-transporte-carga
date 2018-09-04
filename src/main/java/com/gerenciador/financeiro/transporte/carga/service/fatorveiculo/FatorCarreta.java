package com.gerenciador.financeiro.transporte.carga.service.fatorveiculo;

import java.math.BigDecimal;

import com.gerenciador.financeiro.transporte.carga.pojo.VeiculoEnum;

class FatorCarreta implements FatorVeiculo {
	
	@Override
	public BigDecimal calcular(BigDecimal valor) {
		return VeiculoEnum.CARRETA.getFator()	
				.multiply(valor).setScale(2, BigDecimal.ROUND_DOWN);
	}
}
