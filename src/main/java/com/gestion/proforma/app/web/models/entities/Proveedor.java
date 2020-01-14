package com.gestion.proforma.app.web.models.entities; 

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PROVEEDOR")
public class Proveedor implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPROVEEDOR")
	private Integer idproveedor;
	
	@Column(name = "NOMBRE")
	@Size(max=50)
	@NotEmpty
	private String nombre;
	
	@Column(name = "DIRECCION")
	@Size(max=255)
	@NotEmpty
	private String direccion;
	
	@Column(name = "CIUDAD")
	@Size(max=100)
	@NotEmpty
	private String ciudad;
	
	@Column(name = "TELEFONO")
	@Size(max=10)
	@NotEmpty
	private String telefono;
	
	public Proveedor() {
		super();
	}
	
	public Proveedor(Integer id) {
		super();
		this.idproveedor = id;
	}

	public Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
