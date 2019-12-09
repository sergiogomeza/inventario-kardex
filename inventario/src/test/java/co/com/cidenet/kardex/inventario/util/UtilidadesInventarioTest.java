package co.com.cidenet.kardex.inventario.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UtilidadesInventarioTest {

	@Test
	public void obtenerPrecioTotalTransaccion() {
		assertThat(UtilidadesInventario.obtenerPrecioTotalTransaccion(5, 2000D)).isEqualTo(10000D);
	}

	@Test
	public void esIngresoDeProductos() {
		assertThat(UtilidadesInventario.esIngresoDeProductos(5)).isTrue();
		assertThat(UtilidadesInventario.esIngresoDeProductos(-5)).isFalse();
	}

	@Test
	public void obtenerMensajeCambioTest() {
		assertThat(UtilidadesInventario.obtenerMensajeCambio(5, false)).isEqualTo(Constantes.INCREMENTO_PRODUCTO);
		assertThat(UtilidadesInventario.obtenerMensajeCambio(-5, false)).isEqualTo(Constantes.DECREMENTO_PRODUCTO);
		assertThat(UtilidadesInventario.obtenerMensajeCambio(5, true)).isEqualTo(Constantes.INGRESO_NUEVO_PRODUCTO);
	}
}
