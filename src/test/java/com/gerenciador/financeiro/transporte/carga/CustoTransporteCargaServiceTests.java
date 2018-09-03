package com.gerenciador.financeiro.transporte.carga;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.gerenciador.financeiro.transporte.carga.cenario.DetalheTransporteBuilder;
import com.gerenciador.financeiro.transporte.carga.cenario.DetalheTransporteErrado;
import com.gerenciador.financeiro.transporte.carga.exception.ApiErrorResponse;
import com.gerenciador.financeiro.transporte.carga.mensagem.Mensagem;
import com.gerenciador.financeiro.transporte.carga.pojo.DetalheTransporte;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustoTransporteCargaServiceTests {

	private static final String CHAVE_DETALHE_TRANSPORTE = "detalheTransporte";
	private static final String URL_CALCULAR_CUSTO_TRANSPORTE = "/calcularCustoTransporte";
	private static final String URL_LISTAR_VEICULOS =  "/veiculo";

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private Mensagem mensagem;

	@Test
	public void testTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoBauSemCargaExtra() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarRodoviaPavimentaENaoPavimentadaComCaminhaoBauSemCargaExtra();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		BigDecimal total = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, BigDecimal.class);
		assertTrue(DetalheTransporteBuilder.totalRodoviaPavimentaEnaoPavimentadaComCaminhaoBauSemCargaExtra.compareTo(total) == 0);
	}
	
	@Test
	public void testApenasRodoviaPavimentaComCaminhaBauSemCargaExtra() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarApenasRodoviaPavimentaComCaminhaoBauSemCargaExtra();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		BigDecimal total = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, BigDecimal.class);
		assertTrue(DetalheTransporteBuilder.totalApenasRodoviaPavimentaComCaminhaoBauSemCargaExtra.compareTo(total) == 0);
	}
	
	@Test
	public void testApenasRodoviaNaoPavimentaComCaminhaoBauSemCargaExtra() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarApenasRodoviaNaoPavimentaComCaminhaoBauSemCargaExtra();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		BigDecimal total = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, BigDecimal.class);
		assertTrue(DetalheTransporteBuilder.totalApenasRodoviaNaoPavimentaComCaminhaoBauSemCargaExtra.compareTo(total) == 0);
	}
	
	@Test
	public void testTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoBauComCargaExtra() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoBauComCargaExtra();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		BigDecimal total = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, BigDecimal.class);
		assertTrue(DetalheTransporteBuilder.totalTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoBauComCargaExtra.compareTo(total) == 0);
	}
	
	@Test
	public void testTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoCacambaComCargaExtra() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoCacambaComCargaExtra();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		BigDecimal total = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, BigDecimal.class);
		assertTrue(DetalheTransporteBuilder.totalTransporteRodoviaPavimentaENaoPavimentadaComCaminhaoCacambaComCargaExtra.compareTo(total) == 0);
	}
	
	@Test
	public void testTransporteRodoviaPavimentaENaoPavimentadaComCarretaComCargaExtra() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarTransporteRodoviaPavimentaENaoPavimentadaComCarretaComCargaExtra();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		BigDecimal total = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, BigDecimal.class);
		System.out.println(total);
		assertTrue(DetalheTransporteBuilder.totalTransporteRodoviaPavimentaENaoPavimentadaComCarretaComCargaExtra.compareTo(total) == 0);
	}
	
	@Test
	public void testVeiculoNaoCadastrado() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarVeiculoNaoCadastrado();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		List<?> erro = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, List.class);
		String erroVeiculoNaoCadastrado = (String) erro.get(0);
		assertEquals(mensagem.erroVeiculoNaoCadastrado(), erroVeiculoNaoCadastrado);
	}
	
	@Test
	public void testTransporteListarVeiculos() {
		List<?> veiculos = restTemplate.getForObject(URL_LISTAR_VEICULOS, List.class);
		assertTrue(veiculos.size() == 3);
	}
	
	@Test
	public void testSemInformarRodoviaPavimentaENaoPavimentada() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarSemRodoviaPavimentaENaoPavimentada();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		List<?> erro = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, List.class);
		String erroSemRodovias = (String) erro.get(0);
		assertEquals(mensagem.erroSemDistanciaInformada(), erroSemRodovias);
	}
	
	@Test
	public void testSemInformarCargaTransportada() {
		DetalheTransporte detalheTransporte = DetalheTransporteBuilder
				.criarSemInformarCargaTransportada();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		List<?> erro = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, List.class);
		String erroSemCarga = (String) erro.get(0);
		assertEquals(mensagem.erroSemCargaTransportada(), erroSemCarga);
	}
	
	@Test
	public void testErroInterno() {
		DetalheTransporteErrado detalheTransporte = DetalheTransporteBuilder
				.criarErroInterno();
		MultiValueMap<String, Object> detalheTransporteMap = new LinkedMultiValueMap<String, Object>();
		detalheTransporteMap.add(CHAVE_DETALHE_TRANSPORTE, detalheTransporte);
		ApiErrorResponse erro = restTemplate.postForObject(URL_CALCULAR_CUSTO_TRANSPORTE, detalheTransporte, ApiErrorResponse.class);
		assertEquals(mensagem.erroInterno(), erro.getMessage());
	}
	
}
