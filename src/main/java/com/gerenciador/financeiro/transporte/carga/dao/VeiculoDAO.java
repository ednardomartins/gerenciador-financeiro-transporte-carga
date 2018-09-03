package com.gerenciador.financeiro.transporte.carga.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gerenciador.financeiro.transporte.carga.exception.CustoCargaTransportadaException;
import com.gerenciador.financeiro.transporte.carga.pojo.Veiculo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

@Component
public class VeiculoDAO {

	@Value("${arquivo.lista.veiculos}")
	private String veiculosJson;

	private final Logger log = LoggerFactory.getLogger(VeiculoDAO.class);

	public List<Veiculo> listarVeiculos() {
		return listarVeiculos(null);
	}

	public List<Veiculo> listarVeiculos(String caminhoArquivoJson) {
		try {
			if (caminhoArquivoJson == null) {
				caminhoArquivoJson = veiculosJson;
			}
			ClassLoader classLoader = VeiculoDAO.class.getClassLoader();
			File arquivoJson = new File(classLoader.getResource(caminhoArquivoJson).getFile());
			return carregarDadosVeiculo(arquivoJson);
		} catch (Exception e) {
			log.error("Erro ao carregar veiculos", e);
			throw new CustoCargaTransportadaException();
		}
	}

	private List<Veiculo> carregarDadosVeiculo(File arquivoJson) {
		try (JsonReader reader = new JsonReader(
				new InputStreamReader(new FileInputStream(arquivoJson), Charset.forName("ISO-8859-1")))) {
			Gson gson = new Gson();
			Type veiculoLista = new TypeToken<List<Veiculo>>() {
			}.getType();
			return gson.fromJson(reader, veiculoLista);
		} catch (Exception e) {
			log.error("Erro ao carregar veiculos", e);
			throw new CustoCargaTransportadaException();
		}
	}
}
