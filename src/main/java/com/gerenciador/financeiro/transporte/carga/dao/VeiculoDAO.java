package com.gerenciador.financeiro.transporte.carga.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gerenciador.financeiro.transporte.carga.cenario.VeiculoEnum;
import com.gerenciador.financeiro.transporte.carga.exception.CustoCargaTransportadaException;
import com.gerenciador.financeiro.transporte.carga.pojo.Veiculo;

@Component
public class VeiculoDAO {

	private final Logger log = LoggerFactory.getLogger(VeiculoDAO.class);

	public List<Veiculo> listarVeiculos() {
		try {
			 List<Veiculo> veiculos = new ArrayList<>();
			 VeiculoEnum[] veiculosEnum = VeiculoEnum.values();
			 for (VeiculoEnum veiculoEnum : veiculosEnum) {
				Veiculo veiculo = criarVeiculo(veiculoEnum);
				veiculos.add(veiculo);
			}
			 return veiculos;
		} catch (Exception e) {
			log.error("Erro ao carregar veiculos", e);
			throw new CustoCargaTransportadaException();
		}
	}

	private Veiculo criarVeiculo(VeiculoEnum veiculoEnum) {
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(veiculoEnum.getCodigo());
		veiculo.setNome(veiculoEnum.getNome());
		veiculo.setFator(veiculoEnum.getFator());
		return veiculo;
	}

}
