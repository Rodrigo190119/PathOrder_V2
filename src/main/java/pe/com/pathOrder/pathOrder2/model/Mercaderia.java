package pe.com.pathOrder.pathOrder2.model;


import java.util.List;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "mercaderia")
public class Mercaderia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min=10,max=200,message="La descripcion de la mercaderia debe tener entre 10 y 200 caracteres")
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	@Column(name = "tipo", length = 20, nullable = false)
	private String tipo;
	@Column(name = "paraDesastre", columnDefinition = "boolean", nullable = false)
	private boolean paraDesastre;
	@ManyToOne	
	@JoinColumn(name = "ordenDespacho_id")
	private OrdenDespacho ordenDespacho;
	@JsonIgnore
	@OneToMany(mappedBy = "mercaderia", fetch = FetchType.LAZY)
	private List<MercaderiaFacturas> mercaderiasFacturas;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isParaDesastre() {
		return paraDesastre;
	}
	public void setParaDesastre(boolean paraDesastre) {
		this.paraDesastre = paraDesastre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public OrdenDespacho getOrdenDespacho() {
		return ordenDespacho;
	}
	public void setOrdenDespacho(OrdenDespacho ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}
	public List<MercaderiaFacturas> getMercaderiasFacturas() {
		return mercaderiasFacturas;
	}
	public void setMercaderiasFacturas(List<MercaderiaFacturas> mercaderiasFacturas) {
		this.mercaderiasFacturas = mercaderiasFacturas;
	}
	
	
}
