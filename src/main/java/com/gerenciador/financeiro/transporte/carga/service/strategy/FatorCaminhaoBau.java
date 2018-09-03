package com.gerenciador.financeiro.transporte.carga.service.strategy;

import java.math.BigDecimal;

 class FatorCaminhaoBau implements FatorVeiculo {
	
	private static BigDecimal valorFatorCaminhaoBau = BigDecimal.valueOf(1.00).setScale(2, BigDecimal.ROUND_DOWN);

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		return valorFatorCaminhaoBau
				.multiply(valor).setScale(2, BigDecimal.ROUND_DOWN);
	}

}
