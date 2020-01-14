package com.gestion.proforma.app.web.models.entities; 

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="DETALLEFACTURA")
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Basic(optional = false)
	@Column(name="IDDETALLEFACTURA")
	private Integer iddetallefactura;
	 
	@Size(max = 50)
	@Column(name="CANTIDAD")
	@NotEmpty
	private Integer cantidad; 
	
	@Size(max = 50)
	@Column(name="VALORUNITARIO")
	@NotEmpty
	private Float valorunitario;

	@Size(max = 50)
	@Column(name="VALORTOTAL")
	@NotEmpty
	private Float valortotal;

	//relacion de 1 a 1 con elementocatalogo
	@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
	@ManyToOne
	private Producto producto;
	
	//relacion con proforma 1 a 1
	@JoinColumn(name = "IDFACTURA", referencedColumnName = "IDFACTURA")
	@ManyToOne
	private Factura factura;
	
 
	public DetalleFactura() {
		super();
	}
	public DetalleFactura(Integer id) {
		super();
		this.iddetallefactura=id;
	}
	  
	public Integer getIddetallefactura() {
		return iddetallefactura;
	}
	public void setIddetallefactura(Integer iddetallefactura) {
		this.iddetallefactura = iddetallefactura;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getValortotal() {
		return valortotal;
	}
	public void setValortotal(Float valortotal) {
		this.valortotal = valortotal;
	}
	public Float getValorunitario() {
		return valorunitario;
	}
	public void setValorunitario(Float valorunitario) {
		this.valorunitario = valorunitario;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	 

	
	
}
