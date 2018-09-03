package com.gerenciador.financeiro.transporte.carga.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gerenciador.financeiro.transporte.carga.mensagem.Mensagem;

@RestControllerAdvice
public class CustoCargaTransportadaExceptionHandler {
	
	@Autowired
	private Mensagem mensagens;

	@ExceptionHandler(value = {  DadosInvalidosExceptionException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<String> dadosInvalidosExceptionExceptionException(
			DadosInvalidosExceptionException ex) {
		return ex.getErros();
	}
	
	@ExceptionHandler(value = { CustoCargaTransportadaException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorResponse calcularCustoCargaTransportadaExceptionException(
			CustoCargaTransportadaException ex) {
		return new ApiErrorResponse(400, 400, mensagens.erroInterno());
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiErrorResponse unknownException(Exception ex) {
		return new ApiErrorResponse(500, 5002, mensagens.erroInterno());
	}

}