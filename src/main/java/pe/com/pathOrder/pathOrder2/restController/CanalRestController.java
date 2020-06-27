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
import pe.com.pathOrder.pathOrder2.model.Canal;
import pe.com.pathOrder.pathOrder2.service.CanalService;

@Api(value= "Endpoints de Canal")
@RestController
@RequestMapping("api/canales")
public class CanalRestController {
	@Autowired
	private CanalService canalService;
	
	@ApiOperation(value = "EndPoint que permite listar los canales")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Canal>> Listar() {
		ResponseEntity<List<Canal>> response;
		try {
			List<Canal> canales = canalService.findAll();
			response = new ResponseEntity<List<Canal>>(canales, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener un canal por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Canal> GetCanal(@PathVariable("id") int id) {
		try {
			Optional<Canal> canal = canalService.findById(id);
			if (canal.isPresent()) {
				return new ResponseEntity<Canal>(canal.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Canal>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Canal>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar un canal")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Canal> nuevo(@RequestBody Canal canal) {
		try {
			Canal nuevoCanal = canalService.save(canal);
			return new ResponseEntity<Canal>(nuevoCanal, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Canal>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar un canal")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Canal> actualizar(@PathVariable("id") Integer id, @RequestBody Canal canal) {
		try {
			if (id.equals(canal.getId())) {
				Optional<Canal> ca = canalService.findById(id);
				if (ca.isPresent()) {
					Canal canalUpdate = canalService.update(canal);
					return new ResponseEntity<Canal>(canalUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Canal>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Canal>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Canal>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Canal> canal = canalService.findById(id);
			if (canal.isPresent()) {
				canalService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
