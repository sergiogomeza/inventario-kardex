package co.com.cidenet.kardex.inventario.servicio;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cidenet.kardex.inventario.entidad.Producto;
import co.com.cidenet.kardex.inventario.entidad.Registro;
import co.com.cidenet.kardex.inventario.repositorio.RepositorioRegistro;
import co.com.cidenet.kardex.inventario.util.UtilidadesInventario;

@Service
public class ServicioRegistro {

	@Autowired
	RepositorioRegistro repositorioRegistro;

	public Registro registroMovimientoProducto(Producto producto, Integer cantidad, Boolean esNuevo) {
		Registro registro = new Registro();
		registro.setProducto(producto);
		registro.setIngresaProductoStock(UtilidadesInventario.esIngresoDeProductos(cantidad));
		registro.setCantidad(cantidad);
		registro.setPrecioTotalMovimiento(UtilidadesInventario.obtenerPrecioTotalTransaccion(producto.getCantidad(),
				producto.getPrecioProducto()));
		registro.setFechaHoraMovimiento(Calendar.getInstance());
		registro.setObservaciones(UtilidadesInventario.obtenerMensajeCambio(cantidad, esNuevo));
		return repositorioRegistro.save(registro);
	}

}
