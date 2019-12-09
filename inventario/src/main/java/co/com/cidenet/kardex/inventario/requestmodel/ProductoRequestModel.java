package co.com.cidenet.kardex.inventario.requestmodel;

public class ProductoRequestModel {

	private String nombreProducto;

	private String tipoProducto;

	private Double precioProducto;

	private Boolean creadoComunidad;

	private Integer cantidad;

	private String descripcion;

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Boolean getCreadoComunidad() {
		return creadoComunidad;
	}

	public void setCreadoComunidad(Boolean creadoComunidad) {
		this.creadoComunidad = creadoComunidad;
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
