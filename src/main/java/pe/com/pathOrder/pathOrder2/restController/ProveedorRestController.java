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
import pe.com.pathOrder.pathOrder2.model.Proveedor;
import pe.com.pathOrder.pathOrder2.service.ProveedorService;


@Api(value= "Endpoints de Proveedor")
@RestController
@RequestMapping("api/proveedores")
public class ProveedorRestController {
	@Autowired
	private ProveedorService proveedorService;
	
	@ApiOperation(value = "EndPoint que permite listar los proveedores")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proveedor>> Listar() {
		ResponseEntity<List<Proveedor>> response;
		try {
			List<Proveedor> proveedores = proveedorService.findAll();
			response = new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@ApiOperation(value = "EndPoint que permite obtener un proveedor por su id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> GetProveedor(@PathVariable("id") int id) {
		try {
			Optional<Proveedor> proveedor = proveedorService.findById(id);
			if (proveedor.isPresent()) {
				return new ResponseEntity<Proveedor>(proveedor.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Proveedor>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite grabar un proveedor")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> nuevo(@RequestBody Proveedor proveedor) {
		try {
			Proveedor nuevoProveedor = proveedorService.save(proveedor);
			return new ResponseEntity<Proveedor>(nuevoProveedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Proveedor>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "EndPoint que permite actualizar un proveedor")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> actualizar(@PathVariable("id") Integer id, @RequestBody Proveedor proveedor) {
		try {
			if (id.equals(proveedor.getId())) {
				Optional<Proveedor> pr = proveedorService.findById(id);
				if (pr.isPresent()) {
					Proveedor proveedorUpdate = proveedorService.update(proveedor);
					return new ResponseEntity<Proveedor>(proveedorUpdate, HttpStatus.OK);
				} else {
					return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Proveedor>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		try {
			Optional<Proveedor> proveedor = proveedorService.findById(id);
			if (proveedor.isPresent()) {
				proveedorService.deleteById(id);
				return new ResponseEntity<String>("Eliminado", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
