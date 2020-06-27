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
import pe.com.pathOrder.pathOrder2.model.OrdenDespacho;
import pe.com.pathOrder.pathOrder2.service.OrdenDespachoService;

@Api(value= "Endpoints de Orden de despacho")
@RestController
@RequestMapping("api/ordenes")
public class OrdenDespachoRestController {
	@Autowired
	private OrdenDespachoService ordenDespachoService;
	
	@ApiOperation(value = "EndPoint que permite listar las ordenes de despacho")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdenDespacho>> Listar() {
		ResponseEntity<List<OrdenDespacho>> response;
		try {
			List<OrdenDespacho> ordenes = ordenDespachoService.findAll();
			response = new ResponseEntity<List<OrdenDespacho>>(ordenes, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener una orden de despacho por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenDespacho> GetOrdenDespacho(@PathVariable("id") int id) {
		try {
 			Optional<OrdenDespacho> orden = ordenDespachoService.findById(id);
			if (orden.isPresent()) {
				return new ResponseEntity<OrdenDespacho>(orden.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<OrdenDespacho>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<OrdenDespacho>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar una orden de despacho")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenDespacho> nuevo(@RequestBody OrdenDespacho orden) {
		try {
			 OrdenDespacho nuevaOrden = ordenDespachoService.saveWithCanal(orden);
			return new ResponseEntity<OrdenDespacho>(nuevaOrden, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<OrdenDespacho>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar una orden de despacho")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenDespacho> actualizar(@PathVariable("id") Integer id, @RequestBody OrdenDespacho orden) {
		try {
			if (id.equals(orden.getId())) {
				Optional<OrdenDespacho> or = ordenDespachoService.findById(id);
				if (or.isPresent()) {
					OrdenDespacho ordenUpdate = ordenDespachoService.update(orden);
					return new ResponseEntity<OrdenDespacho>(ordenUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<OrdenDespacho>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<OrdenDespacho>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<OrdenDespacho>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<OrdenDespacho> orden = ordenDespachoService.findById(id);
			if (orden.isPresent()) {
				ordenDespachoService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
