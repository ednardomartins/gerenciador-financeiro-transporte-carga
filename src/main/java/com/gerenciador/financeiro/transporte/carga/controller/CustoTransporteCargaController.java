package com.gerenciador.financeiro.transporte.carga.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.financeiro.transporte.carga.pojo.DetalheTransporte;
import com.gerenciador.financeiro.transporte.carga.pojo.Veiculo;
import com.gerenciador.financeiro.transporte.carga.service.CustoTransporteCargaService;
import com.gerenciador.financeiro.transporte.carga.service.VeiculoService;


@RestController 
public class CustoTransporteCargaController {
	
	@Autowired
	private CustoTransporteCargaService custoTransporteCargaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(value = "/calcularCustoTransporte", 
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public BigDecimal calcularCustoTransporte(@RequestBody DetalheTransporte detalheTransporte) {
        return custoTransporteCargaService.calcularCustoTransporte(detalheTransporte);
    }
	
	@RequestMapping(value = "/veiculo", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Veiculo> getVeiculos() {
        return veiculoService.getVeiculosDisponiveis();
    }
}
