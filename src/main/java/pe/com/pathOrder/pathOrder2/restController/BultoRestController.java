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
import pe.com.pathOrder.pathOrder2.model.Bulto;
import pe.com.pathOrder.pathOrder2.service.BultoService;

@Api(value= "Endpoints de Bulto")
@RestController
@RequestMapping("api/bultos")
public class BultoRestController {
	@Autowired
	private BultoService bultoService;
	
	@ApiOperation(value = "EndPoint que permite listar los bultos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bulto>> Listar() {
		ResponseEntity<List<Bulto>> response;
		try {
			List<Bulto> bultos = bultoService.findAll();
			response = new ResponseEntity<List<Bulto>>(bultos, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener un bulto por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bulto> GetBulto(@PathVariable("id") int id) {
		try {
			Optional<Bulto> bulto = bultoService.findById(id);
			if (bulto.isPresent()) {
				return new ResponseEntity<Bulto>(bulto.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Bulto>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Bulto>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar un bulto")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bulto> nuevo(@RequestBody Bulto bulto) {
		try {
			Bulto nuevoBulto = bultoService.save(bulto);
			return new ResponseEntity<Bulto>(nuevoBulto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Bulto>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar un bulto")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bulto> actualizar(@PathVariable("id") Integer id, @RequestBody Bulto bulto) {
		try {
			if (id.equals(bulto.getId())) {
				Optional<Bulto> bu = bultoService.findById(id);
				if (bu.isPresent()) {
					Bulto bultoUpdate = bultoService.update(bulto);
					return new ResponseEntity<Bulto>(bultoUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Bulto>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Bulto>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Bulto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Bulto> bulto = bultoService.findById(id);
			if (bulto.isPresent()) {
				bultoService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
