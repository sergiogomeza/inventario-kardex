package co.com.cidenet.kardex.inventario.util;

public class UtilidadesInventario {
	private UtilidadesInventario() {

	}

	public static Double obtenerPrecioTotalTransaccion(Integer cantidad, Double precioProducto) {
		return cantidad.doubleValue() * precioProducto;
	}

	public static Boolean esIngresoDeProductos(Integer cantidad) {
		Boolean esIngreso = true;
		if (cantidad.intValue() < 0) {
			esIngreso = false;
		}
		return esIngreso;
	}

	public static String obtenerMensajeCambio(Integer cantidad, Boolean esNuevo) {
		String mensaje = "";
		if (esNuevo.booleanValue()) {
			mensaje = Constantes.INGRESO_NUEVO_PRODUCTO;
		} else if (cantidad.intValue() < 0) {
			mensaje = Constantes.DECREMENTO_PRODUCTO;
		} else if (cantidad.intValue() > 0) {
			mensaje = Constantes.INCREMENTO_PRODUCTO;
		} else {
			mensaje = Constantes.SIN_CAMBIOS;
		}
		return mensaje;
	}
}
