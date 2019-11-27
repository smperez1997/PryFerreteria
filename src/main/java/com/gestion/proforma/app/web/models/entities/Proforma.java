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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PROFORMA")
public class Proforma implements Serializable {
	private static final long serialVersionUID=1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID")
	private Integer idproforma;
	
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Calendar fecha;
	
	@Column(name="DESCRIPCIÓN")
	@Size(max=300)
	private String descripcion;
	
	@Column(name="ESTADO")
	private Boolean estado;
	@Column(name="DIRECCIÓN")
	@Size(max=300)
	private String direccion;
	
	@Column(name="IVA")
	@Size(max=5)
	private Float iva;
	@Column(name="TOTAL")
	@Size(max=5)
	private Float total;
	
	//Relacion con cliente 1..1
	@JoinColumn(name="IDCLIENTE",referencedColumnName="ID")
	@ManyToOne
	private Cliente cliente;
	
	
	//relacion con empleado 1..1
	@JoinColumn(name="IDEMPLEADO",referencedColumnName="ID")
	@ManyToOne
	private Empleado empleado;
	
	//relacion 1..n con detalle de proforma
	@OneToMany(mappedBy = "proforma", fetch = FetchType.LAZY)
	private List<DetalleProforma> detalles;//detalles q contienen este elemento del catalogo

		
	
	public Proforma() {
		super();
	}
	public Proforma(Integer id) {
		super();
		this.idproforma=id;
	}
	
	public Integer getIdproforma() {
		return idproforma;
	}
	public void setIdproforma(Integer idproforma) {
		this.idproforma = idproforma;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Float getIva() {
		return iva;
	}
	public void setIva(Float iva) {
		this.iva = iva;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public List<DetalleProforma> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleProforma> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
