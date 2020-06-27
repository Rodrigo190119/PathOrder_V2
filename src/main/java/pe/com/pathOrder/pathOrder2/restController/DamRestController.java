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
import pe.com.pathOrder.pathOrder2.model.Dam;
import pe.com.pathOrder.pathOrder2.service.DamService;


@Api(value= "Endpoints de Dam")
@RestController
@RequestMapping("api/dams")
public class DamRestController {
	@Autowired
	private DamService damService;
	
	@ApiOperation(value = "EndPoint que permite listar los dams")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dam>> Listar() {
		ResponseEntity<List<Dam>> response;
		try {
			List<Dam> dams = damService.findAll();
			response = new ResponseEntity<List<Dam>>(dams, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener una dam por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dam> GetDam(@PathVariable("id") int id) {
		try {
			Optional<Dam> dam = damService.findById(id);
			if (dam.isPresent()) {
				return new ResponseEntity<Dam>(dam.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Dam>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Dam>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar una dam")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dam> nuevo(@RequestBody Dam dam) {
		try {
			Dam nuevoDam = damService.save(dam);
			return new ResponseEntity<Dam>(nuevoDam, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Dam>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar una dam")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dam> actualizar(@PathVariable("id") Integer id, @RequestBody Dam dam) {
		try {
			if (id.equals(dam.getId())) {
				Optional<Dam> d = damService.findById(id);
				if (d.isPresent()) {
					Dam damUpdate = damService.update(dam);
					return new ResponseEntity<Dam>(damUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Dam>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Dam>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Dam>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Dam> dam = damService.findById(id);
			if (dam.isPresent()) {
				damService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
