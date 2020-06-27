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
import pe.com.pathOrder.pathOrder2.model.TipoDespacho;
import pe.com.pathOrder.pathOrder2.service.TipoDespachoService;


@Api(value= "Endpoints de Tipo de Despacho")
@RestController
@RequestMapping("api/tiposDespachos")
public class TipoDespachoRestController {
	@Autowired
	private TipoDespachoService tipoDespachoService;
	
	@ApiOperation(value = "EndPoint que permite listar los tipos de despacho")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDespacho>> Listar() {
		ResponseEntity<List<TipoDespacho>> response;
		try {
			List<TipoDespacho> tipos = tipoDespachoService.findAll();
			response = new ResponseEntity<List<TipoDespacho>>(tipos, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener un tipo de despacho por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoDespacho> GetTipo(@PathVariable("id") int id) {
		try {
			Optional<TipoDespacho> tipo = tipoDespachoService.findById(id);
			if (tipo.isPresent()) {
				return new ResponseEntity<TipoDespacho>(tipo.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<TipoDespacho>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<TipoDespacho>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar un tipo de despacho")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoDespacho> nuevo(@RequestBody TipoDespacho tipo) {
		try {
			TipoDespacho nuevoTipo = tipoDespachoService.save(tipo);
			return new ResponseEntity<TipoDespacho>(nuevoTipo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<TipoDespacho>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar un tipo de despacho")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoDespacho> actualizar(@PathVariable("id") Integer id, @RequestBody TipoDespacho tipo) {
		try {
			if (id.equals(tipo.getId())) {
				Optional<TipoDespacho> ti = tipoDespachoService.findById(id);
				if (ti.isPresent()) {
					TipoDespacho tipoDespachoUpdate = tipoDespachoService.update(tipo);
					return new ResponseEntity<TipoDespacho>(tipoDespachoUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<TipoDespacho>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<TipoDespacho>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<TipoDespacho>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<TipoDespacho> tipo = tipoDespachoService.findById(id);
			if (tipo.isPresent()) {
				tipoDespachoService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
