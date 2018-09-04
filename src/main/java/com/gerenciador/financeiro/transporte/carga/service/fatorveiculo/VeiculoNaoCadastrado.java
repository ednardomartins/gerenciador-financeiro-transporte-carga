package com.gerenciador.financeiro.transporte.carga.service.fatorveiculo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.financeiro.transporte.carga.exception.DadosInvalidosExceptionException;
import com.gerenciador.financeiro.transporte.carga.mensagem.Mensagem;

@Component
class VeiculoNaoCadastrado implements FatorVeiculo {
	
	@Autowired
	private Mensagem mensagens;
	
	@Override
	public BigDecimal calcular(BigDecimal valor) {
		List<String> erros = new ArrayList<>();
		erros.add(mensagens.erroVeiculoNaoCadastrado());
		throw new DadosInvalidosExceptionException(erros);
	}

}
