package com.uem.restcoche.controlador;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uem.restcoche.modelo.entidad.Coche;
import com.uem.restcoche.modelo.negocio.GestorCoche;

@RestController
public class ControladorCoche {
	@Autowired
	private Environment enviroment;
	@Autowired
	private GestorCoche negocio;

	@GetMapping("coche")
	public ResponseEntity<List<Coche>> listar() {
		List<Coche> lista = negocio.listar();
		ResponseEntity<List<Coche>> re = new ResponseEntity<List<Coche>>(lista, HttpStatus.OK);
		return re;
	}

	@GetMapping("coche/{id}")
	public ResponseEntity<Coche> obtener(@PathVariable("id") int id) {
		Coche c = negocio.obtenerCoche(id);
		HttpStatus hp = null;
		if (c != null) {
			String serverPort = enviroment.getProperty("local.server.port");
			c.setMarca(serverPort + ":" + c.getMarca());
			hp = HttpStatus.OK;
		} else {
			hp = HttpStatus.NOT_FOUND;
		}
		ResponseEntity<Coche> re = new ResponseEntity<Coche>(c, hp);
		return re;
	}

	@PostMapping("coche")
	public ResponseEntity<Coche> alta(@RequestBody Coche coche) throws SQLIntegrityConstraintViolationException {
		Coche c = negocio.alta(coche);
		HttpStatus hp = null;
		if (c != null) {
			hp = HttpStatus.CREATED;
		} else {
			hp = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Coche> re = new ResponseEntity<Coche>(c, hp);
		return re;
	}

	@PutMapping("coche/{id}")
	public ResponseEntity<Coche> modificar(@PathVariable("id") int id, @RequestBody Coche coche) {
		coche.setId(id);
		Coche c = negocio.modificar(coche);
		HttpStatus hp = null;
		if (c != null) {
			hp = HttpStatus.OK;
		} else {
			hp = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Coche> re = new ResponseEntity<Coche>(c, hp);
		return re;
	}

	@DeleteMapping("coche/{id}")
	public ResponseEntity<Integer> borrar(@PathVariable("id") int id) {
		boolean borrado = negocio.borrar(id);
		HttpStatus hp = null;
		if (borrado) {
			hp = HttpStatus.CREATED;
		} else {
			hp = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<Integer>(id, hp);
	}
}
