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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FACTURA")
public class Factura implements Serializable {
	private static final long serialVersionUID=1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDFACTURA")
	private Integer idfactura;
	
	
	@Size(max = 50)
	@Column(name="CODIGO")
	@NotEmpty
	private String codigo; 
	
	
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	@NotEmpty
	private Calendar fecha;
	
	@Column(name="DESCRIPCIÓN")
	@Size(max=300)
	@NotEmpty
	private String descripcion;
	
	@Column(name="ESTADO")
	private Boolean estado;
	
	@Column(name="DIRECCIÓN")
	@Size(max=300)
	@NotEmpty
	private String direccion;
	
	@Column(name="IVA")
	@Size(max=10)
	@NotEmpty
	private Float iva;
	
	@Column(name="TOTAL")
	@Size(max=50)
	@NotEmpty
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
	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
	private List<DetalleFactura> detallefactura;//detalles q contienen este elemento del catalogo

		
	
	public Factura() {
		super();
	}
	public Factura(Integer id) {
		super();
		this.idfactura=id;
	}
	
 
	public Integer getIdfactura() {
		return idfactura;
	}
	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
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
	 
	public List<DetalleFactura> getDetallefactura() {
		return detallefactura;
	}
	public void setDetallefactura(List<DetalleFactura> detallefactura) {
		this.detallefactura = detallefactura;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
