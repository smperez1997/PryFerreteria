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
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="EMPLEADO")
public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID")
	private Integer idempleado; 
	
	@Column(name="NOMBRE")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String nombre;
	
	@Column(name="CEDULA")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String cedula; 
	
	@Column(name="CELULAR")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String celular;
	
	//relacion con proforma 0..n
	@OneToMany(mappedBy="empleado",fetch= FetchType.LAZY)
	private List<Factura>factura;
	

	public Empleado() {
		super();
	}
	public Empleado(Integer id) {
		super();
		this.idempleado=id;
	}
	 
	public List<Factura> getFactura() {
		return factura;
	}
	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}
	public Integer getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
