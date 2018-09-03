package com.gerenciador.financeiro.transporte.carga.exception;

import java.io.Serializable;

public class ApiErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	private int code;
	private String message;

	public ApiErrorResponse() {
	}

	public ApiErrorResponse(int status, int code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ApiErrorResponse{" + "status=" + status + ", code=" + code
				+ ", message=" + message + '}';
	}
}