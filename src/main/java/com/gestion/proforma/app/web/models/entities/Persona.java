package com.gestion.proforma.app.web.models.entities; 

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public abstract class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPERSONA")
	private Integer idpersona;
	
	@Column(name="NOMBRES")
	@Size(max=55)
	@NotEmpty
	private String nombres;
	
	@Column(name="APELLIDOS")
	@Size(max=55)
	@NotEmpty
	private String apellidos;
	
	@Column(name="CEDULA")
	@Size(max=15)
	@NotEmpty
	private String cedula;
	
	@Column(name="LUGARNACIMIENTO")
	@Size(max=255)
	private String lugarNacimiento;
	
	@Column(name="SEXO")
	@Size(max=1)
	private String sexo;
	
	@Column(name="IDENTIFICADOR")
	@Size(max=15)
	private String identificador;
	
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
		
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past	
	@Column(name="NACIMIENTO")
	private Calendar nacimiento;
		
	public Persona() {
		super();
	}
	
	public Persona(Integer id) {
		super();
		this.idpersona = id;
	}

	
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

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Calendar getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Calendar nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return apellidos + " "+nombres;
	}
	
	

}
