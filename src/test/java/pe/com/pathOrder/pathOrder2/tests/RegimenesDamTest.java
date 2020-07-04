package pe.com.pathOrder.pathOrder2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pe.com.pathOrder.pathOrder2.model.Dam;
import pe.com.pathOrder.pathOrder2.model.Regimen;

class RegimenesDamTest {

	float FOB_MAX = 2000;

	@Test
	void testDamRegimen() {

		String esperado = "Dam simplificada";
		Dam dam = new Dam();
		Regimen prueba = new  Regimen();
		
		
		dam.setFob(2000);
		prueba.setTipo(" ");
		
		if(dam.getFob() <= FOB_MAX) {
			prueba.setTipo("Dam simplificada");
		}
		assertEquals(esperado, prueba.getTipo());
	}
	
	@Test
	void testDamRegimenNOFob() {
		String esperado = "Dam simplificada";
		Dam dam = new Dam();
		Regimen prueba = new  Regimen();
		
		
		dam.setFob(2000);
		prueba.setTipo(" ");
		
		if(dam.getFob() <= FOB_MAX) {
			prueba.setTipo("Dam simplificada");
		}
		assertEquals(esperado, prueba.getTipo());
	}
	
	@Test
	void testDamImportacion() {
		String esperado = "Importacion";
		
		Dam dam = new Dam();
		Regimen prueba = new  Regimen();
		
		dam.setMandatoElectronico(true);
		prueba.setTipo(" ");
		
		if(dam.isMandatoElectronico() == true) {
			prueba.setTipo("Importacion");;
		}
		assertEquals(esperado, prueba.getTipo());
	}
}
