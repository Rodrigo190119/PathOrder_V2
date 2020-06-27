package pe.com.pathOrder.pathOrder2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "regimen")
public class Regimen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "regimen", fetch = FetchType.LAZY)
	private List<Dam> dams;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Dam> getDams() {
		return dams;
	}
	public void setDams(List<Dam> dams) {
		this.dams = dams;
	}
	
	
}
