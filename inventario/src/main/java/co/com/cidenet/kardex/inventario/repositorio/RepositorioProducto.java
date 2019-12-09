package co.com.cidenet.kardex.inventario.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.cidenet.kardex.inventario.entidad.Producto;

@Repository
public interface RepositorioProducto extends CrudRepository<Producto, Long> {

	public List<Producto> findAllByOrderById();

	public Producto findProductoById(Long idProducto);
}
