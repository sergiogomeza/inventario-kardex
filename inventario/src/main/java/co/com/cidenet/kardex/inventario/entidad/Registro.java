package co.com.cidenet.kardex.inventario.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tk_registro")
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	@JsonIgnore
	private Producto producto;

	@Column(name = "ingresa_producto_stock", nullable = false)
	private Boolean ingresaProductoStock;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precio_movimiento", nullable = false)
	private Double precioTotalMovimiento;

	@Column(name = "fecha_hora_movimiento", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaHoraMovimiento;

	@Column(name = "observaciones", columnDefinition = "varchar(255) default ''")
	private String observaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Boolean getIngresaProductoStock() {
		return ingresaProductoStock;
	}

	public void setIngresaProductoStock(Boolean tipoMovimiento) {
		this.ingresaProductoStock = tipoMovimiento;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioTotalMovimiento() {
		return precioTotalMovimiento;
	}

	public void setPrecioTotalMovimiento(Double precioTotalMovimiento) {
		this.precioTotalMovimiento = precioTotalMovimiento;
	}

	public Calendar getFechaHoraMovimiento() {
		return fechaHoraMovimiento;
	}

	public void setFechaHoraMovimiento(Calendar fechaHoraMovimiento) {
		this.fechaHoraMovimiento = fechaHoraMovimiento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}