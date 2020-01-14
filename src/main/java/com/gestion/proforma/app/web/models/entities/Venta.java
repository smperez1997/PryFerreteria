package com.gestion.proforma.app.web.models.entities; 

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "VENTA")
public class Venta implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDVENTA")
	private Integer idventa;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@Column(name="FECHA_VENTA")
	@NotEmpty
	private Calendar fecha_venta;
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@OneToOne   
	@JoinColumn(name="IDFACTURA",referencedColumnName="IDFACTURA")
	private Factura factura;
	
	public Venta() {
		super();
	}
	
	public Integer getIdventa() {
		return idventa;
	}

	public void setIdventa(Integer idventa) {
		this.idventa = idventa;
	}

	public Calendar getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Calendar fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public Venta(Integer id) {
		super();
		this.idventa = id;
	}
}
