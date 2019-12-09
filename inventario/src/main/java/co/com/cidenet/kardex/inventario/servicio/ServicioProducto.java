package co.com.cidenet.kardex.inventario.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.cidenet.kardex.inventario.entidad.Producto;
import co.com.cidenet.kardex.inventario.entidad.Registro;
import co.com.cidenet.kardex.inventario.excepciones.ActualizacionException;
import co.com.cidenet.kardex.inventario.repositorio.RepositorioProducto;
import co.com.cidenet.kardex.inventario.repositorio.RepositorioRegistro;
import co.com.cidenet.kardex.inventario.requestmodel.ProductoRequestModel;

@Service
public class ServicioProducto {

	@Autowired
	RepositorioProducto repositorioProducto;

	@Autowired
	RepositorioRegistro repositorioRegistro;

	@Autowired
	ServicioRegistro movimientoServicio;

	@Transactional(readOnly = true)
	public List<Producto> getInventario() {
		return repositorioProducto.findAllByOrderById();
	}

	@Transactional(readOnly = true)
	public List<Registro> getMovimientosProducto(Long id) {
		return repositorioRegistro.findByProductoIdOrderByFechaHoraMovimientoDesc(id);
	}

	@Transactional
	public void registroProducto(ProductoRequestModel modeloBody) {
		Producto producto = guardarProducto(modeloBody);
		movimientoServicio.registroMovimientoProducto(producto, producto.getCantidad(), true);
	}

	@Transactional
	public void registroProducto(Long idProducto, Integer cantidad) throws ActualizacionException {
		Producto producto = actualizarCantidad(idProducto, cantidad);
		if (producto != null) {
			movimientoServicio.registroMovimientoProducto(producto, cantidad, false);
		}
	}

	public Producto actualizarCantidad(Long idProducto, Integer valorCambio) throws ActualizacionException {
		Producto producto = repositorioProducto.findProductoById(idProducto);
		Integer cantidadActual = producto.getCantidad();
		Integer cantidadFinal = cantidadActual.intValue() + valorCambio.intValue();
		if (cantidadFinal.intValue() >= 0) {
			producto.setCantidad(cantidadFinal);
			repositorioProducto.save(producto);
		} else {
			throw new ActualizacionException("No hay suficiente stock para realizar esta accion");
		}
		return producto;
	}

	public Producto guardarProducto(ProductoRequestModel modeloBody) {
		Producto producto = new Producto();
		producto.setNombreProducto(modeloBody.getNombreProducto());
		producto.setTipoProducto(modeloBody.getTipoProducto());
		producto.setPrecioProducto(modeloBody.getPrecioProducto());
		producto.setCreadoComunidad(modeloBody.getCreadoComunidad());
		producto.setCantidad(modeloBody.getCantidad());
		producto.setDescripcion(modeloBody.getDescripcion());
		return repositorioProducto.save(producto);
	}
}
