package co.com.cidenet.kardex.inventario.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.cidenet.kardex.inventario.entidad.Producto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositorioProductoTest {

	@Autowired
	private RepositorioProducto repositorioProducto;

	@Test
	public void should_find_all_products() {
		List<Producto> productos = repositorioProducto.findAllByOrderById();
		int nDeProductos = 12;
		assertThat(productos).hasSize(nDeProductos);
	}

	@Test
	public void produc_1_should_be_vaso_spiderman() {
		Producto producto = repositorioProducto.findProductoById(1L);
		assertThat(producto.getNombreProducto()).isEqualTo("vaso spiderman homecoming");
	}

	@Test
	public void produc_8_type_should_be_comic() {
		Producto producto = repositorioProducto.findProductoById(8L);
		assertThat(producto.getTipoProducto()).isEqualTo("comic");
	}

	@Test
	public void produc_10_price_should_be_15000() {
		Producto producto = repositorioProducto.findProductoById(10L);
		assertThat(producto.getPrecioProducto().doubleValue()).isEqualTo(15000D);
	}

	@Test
	public void produc_12_has_10_items() {
		Producto producto = repositorioProducto.findProductoById(12L);
		assertThat(producto.getCantidad().intValue()).isEqualTo(10);
	}
}
