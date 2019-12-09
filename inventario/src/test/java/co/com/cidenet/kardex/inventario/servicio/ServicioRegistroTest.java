package co.com.cidenet.kardex.inventario.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.cidenet.kardex.inventario.entidad.Producto;
import co.com.cidenet.kardex.inventario.entidad.Registro;
import co.com.cidenet.kardex.inventario.repositorio.RepositorioProducto;
import co.com.cidenet.kardex.inventario.repositorio.RepositorioRegistro;

@RunWith(MockitoJUnitRunner.class)
public class ServicioRegistroTest {

	@InjectMocks
	ServicioRegistro servicioRegistro;

	@Mock
	RepositorioProducto repositorioProducto;

	@Mock
	RepositorioRegistro repositorioRegistro;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void guardarRegistroTest() throws ParseException {
		Timestamp time = Timestamp.valueOf("2019-12-02 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time.getTime());
		Registro registro = new Registro();

		Producto producto = new Producto();
		Registro registroEntrada = new Registro();
		Registro registroSalida = new Registro();

		producto.setId(1L);
		producto.setNombreProducto("prueba1");
		producto.setTipoProducto("vaso");
		producto.setPrecioProducto(10000D);
		producto.setCreadoComunidad(false);
		producto.setCantidad(5);
		producto.setDescripcion("");

		registroEntrada.setProducto(producto);
		registroEntrada.setIngresaProductoStock(false);
		registroEntrada.setCantidad(2);
		registroEntrada.setPrecioTotalMovimiento(20000D);
		registroEntrada.setFechaHoraMovimiento(calendar);
		registroEntrada.setObservaciones("Ingreso de nuevas unidades");

		registroSalida.setId(1L);
		registroSalida.setProducto(producto);
		registroSalida.setIngresaProductoStock(false);
		registroSalida.setCantidad(2);
		registroSalida.setPrecioTotalMovimiento(20000D);
		registroSalida.setFechaHoraMovimiento(calendar);
		registroSalida.setObservaciones("Ingreso de nuevas unidades");

		when(repositorioRegistro.save(registro)).thenReturn(registroSalida);
		Registro registroReal = servicioRegistro.registroMovimientoProducto(producto, 2, false, registro);
		verify(repositorioRegistro, times(1)).save(registro);
		assertThat(registroReal.getCantidad()).isEqualTo(2);
	}
}
