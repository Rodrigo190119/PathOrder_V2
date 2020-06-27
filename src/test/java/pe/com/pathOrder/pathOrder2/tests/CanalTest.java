package pe.com.pathOrder.pathOrder2.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import pe.com.pathOrder.pathOrder2.model.Canal;
import pe.com.pathOrder.pathOrder2.model.Mercaderia;

class CanalTest {
	String tipos[] = { "explosivos", "psicotropicos o estupefacientes", "nitrato de potasio"};
	@Test
	void testCanal() {
		String esperado = "rojo";
		Mercaderia mercaderia = new Mercaderia();
		Canal prueba = new Canal();
		
		mercaderia.setDescripcion("xxxxxxxxxxxxx");
		mercaderia.setTipo(" ");
		
		prueba.setNombre(" ");
		prueba.setDescripcion("Descripcion de un canal");
		
		mercaderia = mock(Mercaderia.class);
		when(mercaderia.getTipo()).thenReturn("explosivos");
		
		if(mercaderia.getTipo() == tipos[0] || mercaderia.getTipo() == tipos[1] ||mercaderia.getTipo() == tipos[2]){
			prueba.setNombre("rojo");
			prueba.setDescripcion("Requiere de inspección fisica por un agente de especializado de la Aduana");
		}
		
		assertEquals(esperado, prueba.getNombre());
	}
}
