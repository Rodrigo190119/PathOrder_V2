package pe.com.pathOrder.pathOrder2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "OrdenDespacho")
public class OrdenDespacho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numeroOrden", length = 50, nullable = false)
	private String numeroOrden;
	@Column(name = "prioridad", length = 20, nullable = false)
	private String prioridad;
	@Column(name = "origen", length = 20, nullable = false)
	private String origen;
	@Column(name = "cantidad_de_bultos", nullable = false)
	private Integer cantidadBultos;
	
	@ManyToOne
	@JoinColumn(name = "canal_id")
	private Canal canal;

	@ManyToOne
	@JoinColumn(name = "tipoDespacho_id")
	private TipoDespacho tipoDespacho;

	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "agenteAduanero_id")
	private AgenteAduanero agenteAduanero;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ordenDespacho")
	private List<Bulto> bultos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ordenDespacho")
	private List<Mercaderia> mercaderias;
	
	@Column(name = "observacion", length = 200, nullable = true)
	private String observacion;
	
	@OneToOne
	@JoinColumn(name ="FK_dam", updatable = false,nullable = true)
	private Dam dam;
	
	
	public OrdenDespacho() {
		this.bultos = new ArrayList<>();
		this.mercaderias = new ArrayList<>();
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumeroOrden() {
		return numeroOrden;
	}


	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}


	public String getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public Integer getCantidadBultos() {
		return cantidadBultos;
	}


	public void setCantidadBultos(Integer cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}


	public Canal getCanal() {
		return canal;
	}


	public void setCanal(Canal canal) {
		this.canal = canal;
	}


	public TipoDespacho getTipoDespacho() {
		return tipoDespacho;
	}


	public void setTipoDespacho(TipoDespacho tipoDespacho) {
		this.tipoDespacho = tipoDespacho;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public AgenteAduanero getAgenteAduanero() {
		return agenteAduanero;
	}


	public void setAgenteAduanero(AgenteAduanero agenteAduanero) {
		this.agenteAduanero = agenteAduanero;
	}


	public List<Bulto> getBultos() {
		return bultos;
	}


	public void setBultos(List<Bulto> bultos) {
		this.bultos = bultos;
	}


	public List<Mercaderia> getMercaderias() {
		return mercaderias;
	}


	public void setMercaderias(List<Mercaderia> mercaderias) {
		this.mercaderias = mercaderias;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Dam getDam() {
		return dam;
	}


	public void setDam(Dam dam) {
		this.dam = dam;
	}
	
}
