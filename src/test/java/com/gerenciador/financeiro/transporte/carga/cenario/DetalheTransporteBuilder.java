package com.gerenciador.financeiro.transporte.carga.cenario;

import java.math.BigDecimal;

import com.gerenciador.financeiro.transporte.carga.pojo.DetalheTransporte;

public class DetalheTransporteBuilder {
	
	public static final BigDecimal totalRodoviaPavimentaEnaoPavimentadaComCaminhaoBauSemCargaExtra =  BigDecimal.valueOf(11.60);
	public static final BigDecimal totalApenasRodoviaPavimentaComCaminhaoBauSemCargaExtra =  BigDecimal.valueOf(5.40);
	public static final BigDecimal totalApenasRodoviaNaoPavimentaComCaminhaoBauSemCargaExtra =  BigDecimal.valueOf(6.20);
	public static final BigDecimal totalTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoBauComCargaExtra = BigDecimal.valueOf(13.60);
	public static final BigDecimal totalTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoCacambaComCargaExtra = BigDecimal.valueOf(14.18);
	public static final BigDecimal totalTransporteRodoviaPavimentaENaoPavimentadaComCarretaComCargaExtra = BigDecimal.valueOf(14.99);
	
	
	public static DetalheTransporte criarRodoviaPavimentaENaoPavimentadaComCaminhaoBauSemCargaExtra(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_BAU.getCodigo());
		detalheTransporte.setCargaTransportada(4);
		return detalheTransporte;
	}
	
	public static DetalheTransporte criarApenasRodoviaPavimentaComCaminhaoBauSemCargaExtra(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(null);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_BAU.getCodigo());
		detalheTransporte.setCargaTransportada(4);
		return detalheTransporte;
	}
	
	public static DetalheTransporte criarApenasRodoviaNaoPavimentaComCaminhaoBauSemCargaExtra(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(null);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_BAU.getCodigo());
		detalheTransporte.setCargaTransportada(4);
		return detalheTransporte;
	}

	public static DetalheTransporte criarTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoBauComCargaExtra(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_BAU.getCodigo());
		detalheTransporte.setCargaTransportada(10);
		return detalheTransporte;
	}
	
	public static DetalheTransporte criarTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoCacambaComCargaExtra(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_CACAMBA.getCodigo());
		detalheTransporte.setCargaTransportada(10);
		return detalheTransporte;
	}
	
	public static DetalheTransporte criarTransporteRodoviaPavimentaENaoPavimentadaComCarretaComCargaExtra(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CARRETA.getCodigo());
		detalheTransporte.setCargaTransportada(10);
		return detalheTransporte;
	}
	
	public static DetalheTransporte criarVeiculoNaoCadastrado(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(-22);
		detalheTransporte.setCargaTransportada(10);
		return detalheTransporte;
	}
	
	public static DetalheTransporte criarSemRodoviaPavimentaENaoPavimentada(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(null);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(null);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_BAU.getCodigo());
		detalheTransporte.setCargaTransportada(4);
		return detalheTransporte;
	}
	
	
	public static DetalheTransporte criarSemInformarCargaTransportada(){
		DetalheTransporte detalheTransporte  = new DetalheTransporte();
		detalheTransporte.setDistanciaRodoviaPavimentada(10);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(10);
		detalheTransporte.setVeiculoUtilizado(VeiculoEnum.CAMINHAO_BAU.getCodigo());
		detalheTransporte.setCargaTransportada(0);
		return detalheTransporte;
	}
	
	public static DetalheTransporteErrado criarErroInterno(){
		DetalheTransporteErrado detalheTransporte  = new DetalheTransporteErrado();
		detalheTransporte.setDistanciaRodoviaPavimentada(-340000);
		detalheTransporte.setDistanciaRodoviaNaoPavimentada(-340000);
		detalheTransporte.setVeiculoUtilizado("Teste");
		detalheTransporte.setCargaTransportada(4);
		return detalheTransporte;
	}
	
	
}
