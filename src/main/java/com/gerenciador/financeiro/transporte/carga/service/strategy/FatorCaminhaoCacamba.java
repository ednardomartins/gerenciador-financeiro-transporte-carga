package com.gerenciador.financeiro.transporte.carga.service.strategy;

import java.math.BigDecimal;

class FatorCaminhaoCacamba implements FatorVeiculo {
	
	private static BigDecimal valorFatorCaminhaoCacamba = BigDecimal.valueOf(1.05).setScale(2, BigDecimal.ROUND_DOWN);

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		return valorFatorCaminhaoCacamba
				.multiply(valor).setScale(2, BigDecimal.ROUND_DOWN);
	}

}
