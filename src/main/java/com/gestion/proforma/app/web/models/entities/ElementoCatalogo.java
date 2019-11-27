package com.gestion.proforma.app.web.models.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import com.gestion.proforma.app.web.models.entities.DetalleFactura;

@Entity
@Table(name="ELEMENTOCATALOGO")
public class ElementoCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID")
	private Integer idcatalogo; 
	@Column(name="TIPO")
	private Boolean tipo;
	@Column(name="NOMBRE")
	@Size(max=450)
	private String nombre;
	@Column(name="FOTO")
	@Size(max=350)
	private String foto;
	@Column(name="PRECIO")
	@Size(max=250)
	private Float precio;
	@Column(name="DESCRIPCIÓN")
	@Size(max=250)
	private String descripcion;
	
	//relacion 0..n con detalle de proforma
	@OneToMany(mappedBy = "elementocatalogo", fetch = FetchType.LAZY)
	private List<DetalleFactura> detalles;//detalles q contienen este elemento del catalogo

	
	
	public Integer getIdcatalogo() {
		return idcatalogo;
	}
	public void setIdcatalogo(Integer idcatalogo) {
		this.idcatalogo = idcatalogo;
	}
	public Boolean getTipo() {
		return tipo;
	}
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	
	
	
	
}
