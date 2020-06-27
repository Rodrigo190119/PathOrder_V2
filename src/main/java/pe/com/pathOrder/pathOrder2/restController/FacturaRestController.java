package pe.com.pathOrder.pathOrder2.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.pathOrder.pathOrder2.model.Factura;
import pe.com.pathOrder.pathOrder2.service.FacturaService;

@Api(value= "Endpoints de Factura")
@RestController
@RequestMapping("api/facturas")
public class FacturaRestController {
	@Autowired
	private FacturaService facturaService;
	
	@ApiOperation(value = "EndPoint que permite listar las facturas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Factura>> Listar() {
		ResponseEntity<List<Factura>> response;
		try {
			List<Factura> facturas = facturaService.findAll();
			response = new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener una factura por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Factura> GetFactura(@PathVariable("id") int id) {
		try {
			Optional<Factura> factura = facturaService.findById(id);
			if (factura.isPresent()) {
				return new ResponseEntity<Factura>(factura.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Factura>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar una factura")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Factura> nuevo(@RequestBody Factura factura) {
		try {
			Factura nuevaFactura = facturaService.save(factura);
			return new ResponseEntity<Factura>(nuevaFactura, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Factura>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar una factura")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Factura> actualizar(@PathVariable("id") Integer id, @RequestBody Factura factura) {
		try {
			if (id.equals(factura.getId())) {
				Optional<Factura> fa = facturaService.findById(id);
				if (fa.isPresent()) {
					Factura facturaUpdate = facturaService.update(factura);
					return new ResponseEntity<Factura>(facturaUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Factura>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Factura>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Factura> factura = facturaService.findById(id);
			if (factura.isPresent()) {
				facturaService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
