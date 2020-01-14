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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
 
 
@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	
	@Size(max = 50)
	@Column(name = "NOMBRE")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String nombre;

	@Size(max = 50)
	@Column(name = "APELLIDO")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String apellido;
	
	@Size(max = 10)
	@Column(name = "CEDULA")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String cedula;
	
	@Size(max = 150)
	@Column(name = "DIRECCIÓN")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String direccion;

	@Size(max = 10)
	@Column(name = "CELULAR")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String celular;

	@Size(max = 100)
	@Column(name = "CORREO")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String correo;

		
	@Column(name="FECHA_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Este campo no puede quedar vacío") 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Calendar fechanacimiento;
	
	@Size(max = 250)
	@Column(name = "DESCRIPCIÓN")
	@NotEmpty(message = "Este campo no puede quedar vacío") 
	private String descripcion;

	//relacion con proforma 0..n
	@OneToMany(mappedBy="cliente",fetch= FetchType.LAZY)
	private List<Factura>proforma;
	 
	public Cliente() {
		super();
	}

	public Cliente(Integer id) {
		super();
		this.id = id;
	}
	public List<Factura> getProforma() {
		return proforma;
	}

	public void setProforma(List<Factura> proforma) {
		this.proforma = proforma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Calendar fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
	
	
 
	
}
