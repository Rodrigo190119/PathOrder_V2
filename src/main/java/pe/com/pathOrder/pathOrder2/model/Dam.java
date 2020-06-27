package pe.com.pathOrder.pathOrder2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Dam")
public class Dam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min=10,max=100,message="La descripcion del DAM debe tener entre 10 y 100 caracteres")
	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;
	@Column(name ="CIF", precision = 2, nullable = true)
	private float cif;
	@Column(name = "mandato_electronico", columnDefinition = "boolean", nullable = true)
	private boolean mandatoElectronico;
	@Column(name = "FOB", precision = 2, nullable = true)
	private float fob;
	
	@JsonIgnore
	@OneToOne(mappedBy = "dam", cascade =  CascadeType.ALL)
	OrdenDespacho ordenDespacho;
	@ManyToOne
	@JoinColumn(name = "regimen_id")
	private Regimen regimen;
	
	public Regimen getRegimen() {
		return regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
	}

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

	public OrdenDespacho getOrdenDespacho() {
		return ordenDespacho;
	}

	public void setOrdenDespacho(OrdenDespacho ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}

	public float getCif() {
		return cif;
	}

	public void setCif(float cif) {
		this.cif = cif;
	}

	public boolean isMandatoElectronico() {
		return mandatoElectronico;
	}

	public void setMandatoElectronico(boolean mandatoElectronico) {
		this.mandatoElectronico = mandatoElectronico;
	}

	public float getFob() {
		return fob;
	}

	public void setFob(float fob) {
		this.fob = fob;
	}
	
	
}
