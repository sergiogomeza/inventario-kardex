package co.com.cidenet.kardex.inventario.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import co.com.cidenet.kardex.inventario.requestmodel.ProductoRequestModel;

@RunWith(MockitoJUnitRunner.class)
public class ServicioProductoTest {

	@InjectMocks
	ServicioProducto servicioProducto;

	@Mock
	RepositorioProducto repositorioProducto;

	@Mock
	RepositorioRegistro repositorioRegistro;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void obtenerInventarioTest() {
		List<Producto> lista = new ArrayList<>();
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();

		producto1.setId(1L);
		producto1.setNombreProducto("prueba1");
		producto1.setTipoProducto("vaso");
		producto1.setPrecioProducto(10000D);
		producto1.setCreadoComunidad(false);
		producto1.setCantidad(5);
		producto1.setDescripcion("");

		producto2.setId(2L);
		producto2.setNombreProducto("prueba2");
		producto2.setTipoProducto("vaso");
		producto2.setPrecioProducto(10000D);
		producto2.setCreadoComunidad(false);
		producto2.setCantidad(5);
		producto2.setDescripcion("");

		producto3.setId(3L);
		producto3.setNombreProducto("prueba3");
		producto3.setTipoProducto("vaso");
		producto3.setPrecioProducto(10000D);
		producto3.setCreadoComunidad(false);
		producto3.setCantidad(5);
		producto3.setDescripcion("");

		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);

		when(repositorioProducto.findAllByOrderById()).thenReturn(lista);
		List<Producto> productos = servicioProducto.getInventario();
		assertEquals(3, productos.size());
		verify(repositorioProducto).findAllByOrderById();
	}

	@Test
	public void getMovimientosProductoTest() {
		Timestamp time = Timestamp.valueOf("2019-12-02 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time.getTime());

		List<Registro> lista = new ArrayList<>();
		Producto producto = new Producto();
		Registro registro1 = new Registro();
		Registro registro2 = new Registro();
		Registro registro3 = new Registro();

		producto.setId(1L);
		producto.setNombreProducto("prueba1");
		producto.setTipoProducto("vaso");
		producto.setPrecioProducto(10000D);
		producto.setCreadoComunidad(false);
		producto.setCantidad(5);
		producto.setDescripcion("");

		registro1.setId(1L);
		registro1.setProducto(producto);
		registro1.setIngresaProductoStock(true);
		registro1.setCantidad(2);
		registro1.setPrecioTotalMovimiento(20000D);
		registro1.setFechaHoraMovimiento(calendar);
		registro1.setObservaciones("");

		registro2.setId(2L);
		registro2.setProducto(producto);
		registro2.setIngresaProductoStock(true);
		registro2.setCantidad(3);
		registro2.setPrecioTotalMovimiento(30000D);
		registro2.setFechaHoraMovimiento(calendar);
		registro2.setObservaciones("");

		registro3.setId(3L);
		registro3.setProducto(producto);
		registro3.setIngresaProductoStock(false);
		registro3.setCantidad(-4);
		registro3.setPrecioTotalMovimiento(40000D);
		registro3.setFechaHoraMovimiento(calendar);
		registro3.setObservaciones("");

		lista.add(registro1);
		lista.add(registro2);
		lista.add(registro3);

		when(repositorioRegistro.findByProductoIdOrderByFechaHoraMovimientoDesc(1L)).thenReturn(lista);
		List<Registro> registros = servicioProducto.getMovimientosProducto(1L);
		assertEquals(3, registros.size());
		verify(repositorioRegistro).findByProductoIdOrderByFechaHoraMovimientoDesc(1L);

		registros = servicioProducto.getMovimientosProducto(2L);
		assertEquals(0, registros.size());
	}

	@Test
	public void guardarProductoTest() {
		ProductoRequestModel entrada = new ProductoRequestModel();
		Producto salidaEsperada = new Producto();
		Producto productoGuardar = new Producto();

		entrada.setNombreProducto("El caballero oscuro");
		entrada.setTipoProducto("camiseta");
		entrada.setPrecioProducto(20000D);
		entrada.setCreadoComunidad(false);
		entrada.setCantidad(25);
		entrada.setDescripcion("Edición limitada");

		salidaEsperada.setId(1L);
		salidaEsperada.setNombreProducto("El caballero oscuro");
		salidaEsperada.setTipoProducto("camiseta");
		salidaEsperada.setPrecioProducto(20000D);
		salidaEsperada.setCreadoComunidad(false);
		salidaEsperada.setCantidad(25);
		salidaEsperada.setDescripcion("Edición limitada");

		productoGuardar.setNombreProducto("El caballero oscuro");
		productoGuardar.setTipoProducto("camiseta");
		productoGuardar.setPrecioProducto(20000D);
		productoGuardar.setCreadoComunidad(false);
		productoGuardar.setCantidad(25);
		productoGuardar.setDescripcion("Edición limitada");

		when(repositorioProducto.save(productoGuardar)).thenReturn(salidaEsperada);
		Producto salidaReal = servicioProducto.guardarProducto(entrada);
		assertThat(salidaReal.getNombreProducto()).isEqualTo(productoGuardar.getNombreProducto());
	}
}
