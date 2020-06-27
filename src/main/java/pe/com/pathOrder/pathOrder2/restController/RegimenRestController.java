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
import pe.com.pathOrder.pathOrder2.model.Regimen;
import pe.com.pathOrder.pathOrder2.service.RegimenService;

@Api(value= "Endpoints de Regimen")
@RestController
@RequestMapping("api/regimenes")
public class RegimenRestController {
	@Autowired
	private RegimenService regimenService;
	
	@ApiOperation(value = "EndPoint que permite listar los regimenes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Regimen>> Listar() {
		ResponseEntity<List<Regimen>> response;
		try {
			List<Regimen> regimenes = regimenService.findAll();
			response = new ResponseEntity<List<Regimen>>(regimenes, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener un regimen por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Regimen> GetRegimen(@PathVariable("id") int id) {
		try {
			Optional<Regimen> regimen = regimenService.findById(id);
			if (regimen.isPresent()) {
				return new ResponseEntity<Regimen>(regimen.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Regimen>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Regimen>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar un regimen")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Regimen> nuevo(@RequestBody Regimen regimen) {
		try {
			Regimen nuevoRegimen = regimenService.save(regimen);
			return new ResponseEntity<Regimen>(nuevoRegimen, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Regimen>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar un regimen")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Regimen> actualizar(@PathVariable("id") Integer id, @RequestBody Regimen regimen) {
		try {
			if (id.equals(regimen.getId())) {
				Optional<Regimen> re = regimenService.findById(id);
				if (re.isPresent()) {
					Regimen regimenUpdate = regimenService.update(regimen);
					return new ResponseEntity<Regimen>(regimenUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Regimen>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Regimen>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Regimen>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Regimen> regimen = regimenService.findById(id);
			if (regimen.isPresent()) {
				regimenService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
