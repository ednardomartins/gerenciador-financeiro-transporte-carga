package com.gerenciador.financeiro.transporte.carga.pojo;

public class DetalheTransporte {

	private Integer distanciaRodoviaPavimentada;
	private Integer distanciaRodoviaNaoPavimentada;
	private Integer veiculoUtilizado;
	private Integer cargaTransportada;

	public Integer getDistanciaRodoviaPavimentada() {
		return distanciaRodoviaPavimentada;
	}

	public void setDistanciaRodoviaPavimentada(Integer distanciaRodoviaPavimentada) {
		this.distanciaRodoviaPavimentada = distanciaRodoviaPavimentada;
	}

	public Integer getDistanciaRodoviaNaoPavimentada() {
		return distanciaRodoviaNaoPavimentada;
	}

	public void setDistanciaRodoviaNaoPavimentada(Integer distanciaRodoviaNaoPavimentada) {
		this.distanciaRodoviaNaoPavimentada = distanciaRodoviaNaoPavimentada;
	}

	public Integer getVeiculoUtilizado() {
		return veiculoUtilizado;
	}

	public void setVeiculoUtilizado(Integer veiculoUtilizado) {
		this.veiculoUtilizado = veiculoUtilizado;
	}

	public Integer getCargaTransportada() {
		return cargaTransportada;
	}

	public void setCargaTransportada(Integer cargaTransportada) {
		this.cargaTransportada = cargaTransportada;
	}

}
