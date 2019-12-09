package co.com.cidenet.kardex.inventario.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tk_producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre_producto", nullable = false)
	private String nombreProducto;

	@Column(name = "tipo_producto", nullable = false)
	private String tipoProducto;

	@Column(name = "precio_producto", nullable = false)
	private Double precioProducto;

	@Column(name = "creado_comunidad", nullable = false)
	private Boolean creadoComunidad;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "descripcion", columnDefinition = "varchar(255) default ''")
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Boolean getCreadoComunidad() {
		return creadoComunidad;
	}

	public void setCreadoComunidad(Boolean creadoComunidad) {
		this.creadoComunidad = creadoComunidad;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}