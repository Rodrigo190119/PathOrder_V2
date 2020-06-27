package pe.com.pathOrder.pathOrder2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mercaderia_factura")
public class MercaderiaFacturas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "mercaderia_id")
	private Mercaderia mercaderia;
	@ManyToOne
	@JoinColumn(name = "factura_id")
	private Factura factura;
	@Column(name = "error", columnDefinition = "boolean", nullable = false)
	private boolean error;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Mercaderia getMercaderia() {
		return mercaderia;
	}
	public void setMercaderia(Mercaderia mercaderia) {
		this.mercaderia = mercaderia;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}
