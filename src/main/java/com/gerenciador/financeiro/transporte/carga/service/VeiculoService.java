package com.gerenciador.financeiro.transporte.carga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.financeiro.transporte.carga.dao.VeiculoDAO;
import com.gerenciador.financeiro.transporte.carga.pojo.Veiculo;

@Component
public class VeiculoService {
	
	
	@Autowired
	private VeiculoDAO veiculoDao;
	
	public List<Veiculo> getVeiculosDisponiveis() {
		return veiculoDao.listarVeiculos();
	}

}
