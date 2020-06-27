package pe.com.pathOrder.pathOrder2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pe.com.pathOrder.pathOrder2.model.Factura;
import pe.com.pathOrder.pathOrder2.model.MercaderiaFacturas;

class FacturaRequiereCambioTest {

	@Test
	void testPermitirCambios() {
		boolean esperado = true;
		
		Factura prueba = new Factura();
		MercaderiaFacturas detalle = new MercaderiaFacturas();
		
		prueba.setNumFactura(" ");
		if(prueba.getNumFactura() == " ") {
			detalle.setError(true);
		}
		
		if(detalle.isError() == true) {
			prueba.setPermitirCambio(true);
		}
		assertEquals(esperado, prueba.isPermitirCambio());
	}

}
