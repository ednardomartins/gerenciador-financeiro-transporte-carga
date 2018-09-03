package com.gerenciador.financeiro.transporte.carga.mensagem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "i18n/mensagens.properties")
public class Mensagem{
 
	@Value("${erro.interno}")
	private String erroInterno;
	
	@Value("${erro.sem.distancia.informada}")
	private String erroSemDistanciaInformada;
	
	@Value("${erro.sem.carga.transportada}")
	private String erroSemCargaTransportada;
	
	@Value("${erro.veiculo.nao.cadstrado}")
	private String erroVeiculoNaoCadastrado;
	
	public String erroInterno() {
		return erroInterno;
	}

	public String erroSemDistanciaInformada() {
		return erroSemDistanciaInformada;
	}

	public String erroSemCargaTransportada() {
		return erroSemCargaTransportada;
	}
	
	public String erroVeiculoNaoCadastrado() {
		return erroVeiculoNaoCadastrado;
	}
}