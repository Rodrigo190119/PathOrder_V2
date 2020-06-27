package pe.com.pathOrder.pathOrder2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pe.com.pathOrder.pathOrder2.model.Dam;
import pe.com.pathOrder.pathOrder2.model.OrdenDespacho;

class DamTestCreated {

	@Test
	void crearDamError() {
		OrdenDespacho prueba = new OrdenDespacho();
		prueba.setDam(null);
		
		if(prueba.getDam() == null) {
			fail("No hay Dam creada");
		}
	}

	@Test
	void crearDamCorrecto() {
		boolean resultado = false;
		OrdenDespacho prueba = new OrdenDespacho();
		Dam dam = new Dam();
		
		dam.setOrdenDespacho(prueba);
		prueba.setDam(dam);
		
		if(dam.getId() == prueba.getDam().getId()) resultado = true;
		
		assertEquals(true, resultado);
	}
}
