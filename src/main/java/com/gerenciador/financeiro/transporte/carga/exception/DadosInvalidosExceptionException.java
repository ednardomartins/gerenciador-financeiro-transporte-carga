package com.gerenciador.financeiro.transporte.carga.exception;

import java.util.ArrayList;
import java.util.List;

public class DadosInvalidosExceptionException extends IllegalStateException{
	
	private static final long serialVersionUID = 3261640677385677522L;
	
	private final List<String> erros =  new ArrayList<>(); 
	
	public DadosInvalidosExceptionException(List<String>  erros) {
		this.erros.addAll(erros);
	}

	public List<String> getErros() {
		return erros;
	}
}
