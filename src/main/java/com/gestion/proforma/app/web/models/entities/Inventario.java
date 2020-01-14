package com.gestion.proforma.app.web.models.entities; 

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "INVENTARIO")
public class Inventario implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDINVENTARIO")
	private Integer idinventario;
	
	@Column(name = "CANTIDAD_INICIAL")
	@NotEmpty
	private Integer cantidad_inicial;
	
	@Column(name = "CANTIDAD_DISPONIBLE")
	@NotEmpty
	private Integer cantidad_disponible;
	
	@OneToOne   
	@JoinColumn(name="IDPRODUCTO",referencedColumnName="IDPRODUCTO")
	private Producto producto;
	
	

	public Inventario() {
		super();
	}
	
	public Inventario(Integer id) {
		super();
		this.idinventario = id;
	}

	public Integer getIdinventario() {
		return idinventario;
	}

	public void setIdinventario(Integer idinventario) {
		this.idinventario = idinventario;
	}

	public Integer getCantidad_inicial() {
		return cantidad_inicial;
	}

	public void setCantidad_inicial(Integer cantidad_inicial) {
		this.cantidad_inicial = cantidad_inicial;
	}

	public Integer getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(Integer cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}
}
