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

@Entity
@Table(name="DETALLEPROFORMA")
public class DetalleProforma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID")
	private Integer iddetalleproforma;
	 
	@Column(name="CANTIDAD")
	private Float cantidad; 
	@Column(name="SUBTOTAL")
	private Float subtotal;

	
	//relacion de 1 a 1 con elementocatalogo
	@JoinColumn(name = "IDELEMENTOCATALOGO", referencedColumnName = "ID")
	@ManyToOne
	private ElementoCatalogo elementocatalogo;
	
	//relacion con proforma 1 a 1
	@JoinColumn(name = "IDPROFORMA", referencedColumnName = "ID")
	@ManyToOne
	private Proforma proforma;
	
	public DetalleProforma() {
		super();
	}
	public DetalleProforma(Integer id) {
		super();
		this.iddetalleproforma=id;
	}
	public Integer getIddetalleproforma() {
		return iddetalleproforma;
	}
	public void setIddetalleproforma(Integer iddetalleproforma) {
		this.iddetalleproforma = iddetalleproforma;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public ElementoCatalogo getElementocatalogo() {
		return elementocatalogo;
	}
	public void setElementocatalogo(ElementoCatalogo elementocatalogo) {
		this.elementocatalogo = elementocatalogo;
	}
	public Proforma getProforma() {
		return proforma;
	}
	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	} 
	
	
}
