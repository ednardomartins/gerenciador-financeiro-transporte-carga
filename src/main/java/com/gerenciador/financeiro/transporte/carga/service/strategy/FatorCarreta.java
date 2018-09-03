package com.gerenciador.financeiro.transporte.carga.service.strategy;

import java.math.BigDecimal;

class FatorCarreta implements FatorVeiculo {
	
	private static BigDecimal valorFatorCarreta = BigDecimal.valueOf(1.12).setScale(2, BigDecimal.ROUND_DOWN);

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		return valorFatorCarreta	
				.multiply(valor).setScale(2, BigDecimal.ROUND_DOWN);
	}
}
