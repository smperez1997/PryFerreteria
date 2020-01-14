package com.gestion.proforma.app.web.models.entities;

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min; 
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;

 
@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IDPRODUCTO")
	private Integer idproducto;
	
	@Size(max = 100)
	@Column(name = "NOMBRE")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String nombre;

	@Size(max = 50)
	@Column(name = "TIPO")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String tipo;
	
	@Size(max = 100)
	@Column(name = "IMAGEN")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String imagen;

	@NotNull(message = "Este campo no puede quedar vacío")  
	@Min(value = 1, message = "El precio no puede ser inferior a 1 USD") 
	@Max(value = 1000000000, message = "El precio no puede ser inferior a 1000000000 USD") 

	@Column(name = "PRECIO")
	private Float precio;

	@Size(max = 200)
	@Column(name = "DESCRIPCION")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String descripcion;
	
	
	//Bitácora
	@Column(name="CREADOPOR")
	@Size(max=35)
	private String creadoPor;
	
	@Column(name="CREADOEN")
	private Calendar creadoEn;
	
	@PrePersist
	public void prePersist() {
	    creadoEn = Calendar.getInstance();
	    SecurityContext context = SecurityContextHolder.getContext();
	    creadoPor = context.getAuthentication().getName();
	}
 
	//relacion con proforma 0..n
	@OneToMany(mappedBy="producto",fetch= FetchType.LAZY)
	private List<Factura>factura;
	 
	@OneToOne   
	@JoinColumn(name="IDPROVEEDOR",referencedColumnName="IDPROVEEDOR")

	
	private Proveedor proveedor;
	
	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Calendar getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Calendar creadoEn) {
		this.creadoEn = creadoEn;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

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
