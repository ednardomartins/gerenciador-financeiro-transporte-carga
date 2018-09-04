package com.gerenciador.financeiro.transporte.carga.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gerenciador.financeiro.transporte.carga.exception.DadosInvalidosExceptionException;
import com.gerenciador.financeiro.transporte.carga.mensagem.Mensagem;
import com.gerenciador.financeiro.transporte.carga.pojo.DetalheTransporte;
import com.gerenciador.financeiro.transporte.carga.service.fatorveiculo.FatorVeiculo;
import com.gerenciador.financeiro.transporte.carga.service.fatorveiculo.FatorVeiculoFactory;

@Component
public class CustoTransporteCargaService {

	@Value("${valor.porkm.rodovia.pavimentada}")
	private BigDecimal valorRodoviaPavimentada;

	@Value("${valor.porkm.rodovia.nao.pavimentada}")
	private BigDecimal valorRodoviaNaoPavimentada;

	@Value("${valor.portonelada.extra}")
	private BigDecimal valorPorToneladaExtra;

	@Value("${total.toneladas.carga.sem.custo.extra}")
	private Integer totalToneladasSemCustoExtra;

	@Autowired
	private Mensagem mensagens;

	@Autowired
	private FatorVeiculoFactory fatorVeiculoFactory;

	public BigDecimal calcularCustoTransporte(DetalheTransporte detalhe) {
		validarDadosFormulario(detalhe);
		BigDecimal valor = calcularCustoTransporteRodovias(detalhe);
		valor = calcularFatorDoVeiculo(detalhe, valor);
		return calcularExcessoDeCarga(detalhe, valor);
	}

	private void validarDadosFormulario(DetalheTransporte detalhe) {
		List<String> erros = new ArrayList<>();
		if (!verificarSeValorExiste(detalhe.getDistanciaRodoviaPavimentada())
				&& !verificarSeValorExiste(detalhe.getDistanciaRodoviaNaoPavimentada())) {
			erros.add(mensagens.erroSemDistanciaInformada());
		}
		if (!verificarSeValorExiste(detalhe.getCargaTransportada())) {
			erros.add(mensagens.erroSemCargaTransportada());
		}
		if (!erros.isEmpty()) {
			throw new DadosInvalidosExceptionException(erros);
		}
	}

	private boolean verificarSeValorExiste(Integer valor) {
		return valor != null && valor != 0;
	}

	private BigDecimal calcularCustoTransporteRodovias(DetalheTransporte detalhe) {
		BigDecimal custoRodoviaPavimentada = calcularCustoRodoviaPavimentada(detalhe);
		BigDecimal custoRodoviaNaoPavimentada = calcularCustoRodoviaNaoPavimentada(detalhe);
		return custoRodoviaPavimentada.add(custoRodoviaNaoPavimentada).setScale(2, BigDecimal.ROUND_DOWN);
	}

	private BigDecimal calcularCustoRodoviaPavimentada(DetalheTransporte detalhe) {
		if (detalhe.getDistanciaRodoviaPavimentada() == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal cargaTransportada = BigDecimal.valueOf(detalhe.getDistanciaRodoviaPavimentada());
		return valorRodoviaPavimentada.multiply(cargaTransportada).setScale(2, BigDecimal.ROUND_DOWN);
	}

	private BigDecimal calcularCustoRodoviaNaoPavimentada(DetalheTransporte detalhe) {
		if (detalhe.getDistanciaRodoviaNaoPavimentada() == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal dargaTransportada = BigDecimal.valueOf(detalhe.getDistanciaRodoviaNaoPavimentada());
		return valorRodoviaNaoPavimentada.multiply(dargaTransportada).setScale(2, BigDecimal.ROUND_DOWN);
	}

	private BigDecimal calcularFatorDoVeiculo(DetalheTransporte detalhe, BigDecimal valor) {
		FatorVeiculo fatorVeiculo = fatorVeiculoFactory.criarFatorVeiculo(detalhe.getVeiculoUtilizado());
		return fatorVeiculo.calcular(valor);
	}

	private BigDecimal calcularExcessoDeCarga(DetalheTransporte detalhe, BigDecimal valor) {
		Integer cargaTransportada = detalhe.getCargaTransportada();
		if (cargaTransportada <= totalToneladasSemCustoExtra) {
			return valor;
		}
		Integer cargaExtra = cargaTransportada - totalToneladasSemCustoExtra;
		BigDecimal valorCargaExtra = valorPorToneladaExtra.multiply(BigDecimal.valueOf(cargaExtra));
		Integer distanciaTotal = getDistanciaTotal(detalhe);
		BigDecimal valorAcrescimo = valorCargaExtra.multiply(BigDecimal.valueOf(distanciaTotal));
		return valor.add(valorAcrescimo);
	}

	private Integer getDistanciaTotal(DetalheTransporte detalhe) {
		return detalhe.getDistanciaRodoviaPavimentada() + detalhe.getDistanciaRodoviaNaoPavimentada();
	}
}
