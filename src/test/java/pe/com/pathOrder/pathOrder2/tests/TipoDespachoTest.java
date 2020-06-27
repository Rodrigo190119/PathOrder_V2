package pe.com.pathOrder.pathOrder2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import pe.com.pathOrder.pathOrder2.model.Mercaderia;
import pe.com.pathOrder.pathOrder2.model.TipoDespacho;

class TipoDespachoTest {
	
	String tiposMercaderias[] = { "organos humanos", "sangre humana", "mercancia perecedera", "medicamentos o vacunas",
				"metales preciosos", "cristales preciosos"};
	
	
	@Test
	void testTipoMercaderiaXTipoDespacho() {
		
		String esperado = "urgente";
		Mercaderia mercaderia = new Mercaderia();
		TipoDespacho prueba = new TipoDespacho();
		
		mercaderia.setParaDesastre(false);
		mercaderia.setDescripcion(" ");
		
		mercaderia = mock(Mercaderia.class);
		when(mercaderia.getTipo()).thenReturn("sangre humana");
		
		if(mercaderia.getTipo() == tiposMercaderias[0] || 
				mercaderia.getTipo() == tiposMercaderias[1] ||
				mercaderia.getTipo() == tiposMercaderias[2] ||
				mercaderia.getTipo() == tiposMercaderias[3] ||
				mercaderia.getTipo() == tiposMercaderias[4] || 
				mercaderia.getTipo() == tiposMercaderias[5]) {
		
			prueba.setNombre("urgente");
		}
		assertEquals(esperado, prueba.getNombre());
	}
	
	@Test
	void testTipoDesastreIs() {
		String esperado = "socorro";
		
		TipoDespacho prueba = new TipoDespacho();
		Mercaderia x = new Mercaderia();
		
		x.setDescripcion(" ");
		x.setTipo(" ");
		
		x = mock(Mercaderia.class);
		when(x.isParaDesastre()).thenReturn(true);
		
		if(x.isParaDesastre() == true) {
			prueba.setNombre("socorro");
		}
		assertEquals(esperado, prueba.getNombre());
	}

}
