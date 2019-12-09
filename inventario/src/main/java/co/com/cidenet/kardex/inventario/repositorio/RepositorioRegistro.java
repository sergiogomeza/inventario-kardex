package co.com.cidenet.kardex.inventario.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.cidenet.kardex.inventario.entidad.Registro;

@Repository
public interface RepositorioRegistro extends CrudRepository<Registro, Long> {

	List<Registro> findByProductoIdOrderByFechaHoraMovimientoDesc(Long idProducto);
}
