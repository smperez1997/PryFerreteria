package com.gestion.proforma.app.web.models.entities;

import java.awt.Image;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer idproducto;
	
	@Size(max = 100)
	@Column(name = "NOMBRE")
	@NotEmpty
	private String nombre;

	@Size(max = 50)
	@Column(name = "TIPO")
	@NotEmpty
	private String tipo;
	
	@Size(max = 100)
	@Column(name = "IMAGEN")
	@NotEmpty
	private String imagen;
	
	@Size(max = 50)
	@Column(name = "PRECIO")
	@NotEmpty
	private Float precio;

	@Size(max = 200)
	@Column(name = "DESCRIPCION")
	@NotEmpty
	private String descripcion;
 
	//relacion con proforma 0..n
	@OneToMany(mappedBy="cliente",fetch= FetchType.LAZY)
	private List<Factura>factura;
	 
	public List<Factura> getFactura() {
		return factura;
	}

	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}

	public Producto() {
		super();
	}

	public Producto(Integer id) {
		super();
		this.idproducto = id;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	
 
	
}
