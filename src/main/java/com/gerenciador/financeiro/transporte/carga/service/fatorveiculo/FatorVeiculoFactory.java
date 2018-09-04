package com.gerenciador.financeiro.transporte.carga.service.fatorveiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.financeiro.transporte.carga.pojo.VeiculoEnum;

@Component
public class FatorVeiculoFactory {
	
	@Autowired
	private VeiculoNaoCadastrado veiculoNaoCadastrado;
	
	public FatorVeiculo criarFatorVeiculo(Integer codigoVeiculo){
		if(VeiculoEnum.CAMINHAO_BAU.getCodigo().equals(codigoVeiculo)){
			return new FatorCaminhaoBau();
		}
		if(VeiculoEnum.CAMINHAO_CACAMBA.getCodigo().equals(codigoVeiculo)){
			return new FatorCaminhaoCacamba();
		}
		if(VeiculoEnum.CARRETA.getCodigo().equals(codigoVeiculo)){
			return new FatorCarreta();
		}
		return veiculoNaoCadastrado;
	}

}
