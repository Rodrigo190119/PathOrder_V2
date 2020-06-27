package pe.com.pathOrder.pathOrder2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "bulto")
public class Bulto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Column(name ="peso", precision = 4 , nullable = false, columnDefinition = "float")
	private float peso;
	@Column(name = "vigente", nullable = false, columnDefinition = "boolean")
	private boolean esVigente;
	
	@ManyToOne
	@JoinColumn(name = "ordenDespacho_id")
	private OrdenDespacho ordenDespacho;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public OrdenDespacho getOrdenDespacho() {
		return ordenDespacho;
	}
	public void setOrdenDespacho(OrdenDespacho ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}
	public boolean isEsVigente() {
		return esVigente;
	}
	public void setEsVigente(boolean esVigente) {
		this.esVigente = esVigente;
	}
	
	
}
