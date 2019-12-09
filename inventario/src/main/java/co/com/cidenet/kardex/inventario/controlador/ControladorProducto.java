package co.com.cidenet.kardex.inventario.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cidenet.kardex.inventario.entidad.Producto;
import co.com.cidenet.kardex.inventario.entidad.Registro;
import co.com.cidenet.kardex.inventario.excepciones.ActualizacionException;
import co.com.cidenet.kardex.inventario.requestmodel.ProductoRequestModel;
import co.com.cidenet.kardex.inventario.servicio.ServicioProducto;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inventario")
public class ControladorProducto {
	@Autowired
	private ServicioProducto servicioProducto;

	@GetMapping
	public @ResponseBody List<Producto> getInventario() {
		return servicioProducto.getInventario();
	}

	@GetMapping("/{id}/registros")
	public @ResponseBody List<Registro> getMovimientosProducto(@PathVariable Long id) {
		return servicioProducto.getMovimientosProducto(id);
	}

	@PostMapping
	public void guardarProducto(@RequestBody ProductoRequestModel modeloBody) {
		servicioProducto.registroProducto(modeloBody);
	}

	@PutMapping("/actualizar/{idProducto}/{cantidad}")
	public ResponseEntity<String> actualizarProducto(@PathVariable Long idProducto, @PathVariable Integer cantidad) {
		try {
			servicioProducto.registroProducto(idProducto, cantidad);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ActualizacionException errorActualizando) {
			return new ResponseEntity<>(errorActualizando.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
