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
import pe.com.pathOrder.pathOrder2.model.AgenteAduanero;
import pe.com.pathOrder.pathOrder2.service.AgenteAduaneroService;

@Api(value= "Endpoints de Agente Aduanero")
@RestController
@RequestMapping("api/agentesAduaneros")
public class AgenteAduaneroRestController {
	
	@Autowired
	private AgenteAduaneroService agenteAduaneroServive;
	
	@ApiOperation(value = "EndPoint que permite listar los agentes aduaneros")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AgenteAduanero>> Listar() {
		ResponseEntity<List<AgenteAduanero>> response;
		try {
			List<AgenteAduanero> agentes = agenteAduaneroServive.findAll();
			response = new ResponseEntity<List<AgenteAduanero>>(agentes, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener un agente aduanero por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgenteAduanero> GetAgentAduanero(@PathVariable("id") int id) {
		try {
			Optional<AgenteAduanero> agente = agenteAduaneroServive.findById(id);
			if (agente.isPresent()) {
				return new ResponseEntity<AgenteAduanero>(agente.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<AgenteAduanero>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<AgenteAduanero>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar un agente aduanero")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgenteAduanero> nuevo(@RequestBody AgenteAduanero agenteAduanero) {
		try {
			AgenteAduanero nuevoAgente = agenteAduaneroServive.save(agenteAduanero);
			return new ResponseEntity<AgenteAduanero>(nuevoAgente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<AgenteAduanero>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar un agente aduanero")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgenteAduanero> actualizar(@PathVariable("id") Integer id, @RequestBody AgenteAduanero agenteAduanero) {
		try {
			if (id.equals(agenteAduanero.getId())) {
				Optional<AgenteAduanero> ag = agenteAduaneroServive.findById(id);
				if (ag.isPresent()) {
					AgenteAduanero agenteAduaneroUpdate = agenteAduaneroServive.update(agenteAduanero);
					return new ResponseEntity<AgenteAduanero>(agenteAduaneroUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<AgenteAduanero>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<AgenteAduanero>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<AgenteAduanero>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<AgenteAduanero> agenteaAduanero = agenteAduaneroServive.findById(id);
			if (agenteaAduanero.isPresent()) {
				agenteAduaneroServive.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
