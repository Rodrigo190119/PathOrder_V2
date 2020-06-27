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
import pe.com.pathOrder.pathOrder2.model.Mercaderia;
import pe.com.pathOrder.pathOrder2.service.MercaderiaService;

@Api(value= "Endpoints de Mercaderias")
@RestController
@RequestMapping("api/mercaderias")
public class MercaderiaRestController {
	@Autowired
	private MercaderiaService mercaderiaService;
	
	@ApiOperation(value = "EndPoint que permite listar las mercaderias")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mercaderia>> Listar() {
		ResponseEntity<List<Mercaderia>> response;
		try {
			List<Mercaderia> mercaderias = mercaderiaService.findAll();
			response = new ResponseEntity<List<Mercaderia>>(mercaderias, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener una mercaderia por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mercaderia> GetMercaderia(@PathVariable("id") int id) {
		try {
			Optional<Mercaderia> mercaderia = mercaderiaService.findById(id);
			if (mercaderia.isPresent()) {
				return new ResponseEntity<Mercaderia>(mercaderia.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Mercaderia>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Mercaderia>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar una mercaderia")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mercaderia> nuevo(@RequestBody Mercaderia mercaderia) {
		try {
			Mercaderia nuevaMercaderia = mercaderiaService.save(mercaderia);
			return new ResponseEntity<Mercaderia>(nuevaMercaderia, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Mercaderia>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar una mercaderia")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mercaderia> actualizar(@PathVariable("id") Integer id, @RequestBody Mercaderia mercaderia) {
		try {
			if (id.equals(mercaderia.getId())) {
				Optional<Mercaderia> me = mercaderiaService.findById(id);
				if (me.isPresent()) {
					Mercaderia mercaderiaUpdate = mercaderiaService.update(mercaderia);
					return new ResponseEntity<Mercaderia>(mercaderiaUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Mercaderia>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Mercaderia>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Mercaderia>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Mercaderia> mercaderia = mercaderiaService.findById(id);
			if (mercaderia.isPresent()) {
				mercaderiaService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
