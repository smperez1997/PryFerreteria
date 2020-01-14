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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.proforma.app.web.models.entities.Pais;
import com.gestion.proforma.app.web.models.entities.Persona;


@Entity
@Table(name="EMPLEADO")
public class Empleado extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name= "IDPAIS", referencedColumnName = "IDPAIS")
	@ManyToOne
	private Pais pais;
	
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
	@JsonIgnore
	@OneToMany(mappedBy="empleado",fetch= FetchType.LAZY)
	private List<Factura>factura;
	

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
	    
	public Pais getPais() {
			return pais;
		}

		public void setPais(Pais pais) {
			this.pais = pais;
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

	public Empleado() {
		super();
	}
	public Empleado(Integer id) {
		super();
		this.setIdpersona(id);
	}
	 
	public List<Factura> getFactura() {
		return factura;
	}
	public void setFactura(List<Factura> factura) {
		this.factura = factura;
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
