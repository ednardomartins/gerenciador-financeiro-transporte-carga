package com.gerenciador.financeiro.transporte.carga;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.gerenciador.financeiro.transporte.carga.dao.VeiculoDAO;
import com.gerenciador.financeiro.transporte.carga.exception.CustoCargaTransportadaException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VeiculoDaoTest {
	
	@Autowired
	private VeiculoDAO veiuloDao;
	
	@Test(expected = CustoCargaTransportadaException.class)
	public void testErroAoListarVeiculos() throws CustoCargaTransportadaException {
		veiuloDao.listarVeiculos("d");
	}

}
