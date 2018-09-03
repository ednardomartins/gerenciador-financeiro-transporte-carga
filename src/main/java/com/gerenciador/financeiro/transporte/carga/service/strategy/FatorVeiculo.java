package com.gerenciador.financeiro.transporte.carga.service.strategy;

import java.math.BigDecimal;

public interface FatorVeiculo {
	
	BigDecimal calcular(BigDecimal valor);

}
