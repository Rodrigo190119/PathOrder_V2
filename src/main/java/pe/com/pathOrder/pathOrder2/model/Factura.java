package pe.com.pathOrder.pathOrder2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_de_factura",length = 30, nullable = false)
	private String numFactura;
	@Size(min=10,max=200,message="La descripcion de la factura debe tener entre 10 y 200 caracteres")
	@Column(name = "descripcion",length = 200, nullable = false)
	private String descrpicion;
	@Column(name = "unidad",columnDefinition = "tinyint")
	private Integer unidad;
	@Temporal(TemporalType.DATE)
	@Column(name ="fecha", nullable = false)
	private Date fecha;
	@Column(name = "permitir_cambio", columnDefinition = "boolean", nullable = false)
	private boolean permitirCambio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "factura")
	private List<MercaderiaFacturas> mercaderiaFacturas;

	public boolean isPermitirCambio() {
		return permitirCambio;
	}

	public void setPermitirCambio(boolean permitirCambio) {
		this.permitirCambio = permitirCambio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public String getDescrpicion() {
		return descrpicion;
	}

	public void setDescrpicion(String descrpicion) {
		this.descrpicion = descrpicion;
	}

	public Integer getUnidad() {
		return unidad;
	}

	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<MercaderiaFacturas> getMercaderiaFacturas() {
		return mercaderiaFacturas;
	}

	public void setMercaderiaFacturas(List<MercaderiaFacturas> mercaderiaFacturas) {
		this.mercaderiaFacturas = mercaderiaFacturas;
	}
	
	
}
