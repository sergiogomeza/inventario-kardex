package co.com.cidenet.kardex.inventario.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.cidenet.kardex.inventario.entidad.Registro;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositorioRegistroTest {

	@Autowired
	private RepositorioRegistro repositorioRegistro;
	
	@Test
	public void product_8_should_have_1_movement_registry() {
		List<Registro> registros =	repositorioRegistro.findByProductoIdOrderByFechaHoraMovimientoDesc(8L);
		assertThat(registros).hasSize(1);
	}
	
	@Test
	public void product_6_total_transaction_should_be_410000() {
		List<Registro> registros =	repositorioRegistro.findByProductoIdOrderByFechaHoraMovimientoDesc(6L);
		assertThat(registros.get(0).getPrecioTotalMovimiento().doubleValue()).isEqualTo(410000D);
	}
	
	@Test
	public void product_10_registry_should_add_10_items() {
		List<Registro> registros =	repositorioRegistro.findByProductoIdOrderByFechaHoraMovimientoDesc(10L);
		assertThat(registros.get(0).getCantidad().intValue()).isEqualTo(10);
	}
	
}
