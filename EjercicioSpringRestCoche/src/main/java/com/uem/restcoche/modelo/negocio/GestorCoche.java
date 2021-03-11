package com.uem.restcoche.modelo.negocio;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uem.restcoche.modelo.entidad.Coche;
import com.uem.restcoche.modelo.persistencia.DaoCoche;

@Service
public class GestorCoche {
	@Autowired
	private DaoCoche daoCoche;
	
	public List<Coche> listar() {
		List<Coche> lista = daoCoche.findAll();
		return lista;
	}

	public Coche obtenerCoche(int id) {
		Optional<Coche> opt = daoCoche.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Coche alta(Coche coche) throws SQLIntegrityConstraintViolationException {
		Coche c = null;
		try {
			c = daoCoche.save(coche);
		} catch (Exception e) {
			System.out.println("As ponido la misma matricula so ZOPENCO");
		}
		return c;
		
	}

	public Coche modificar(Coche coche) {
		Coche c = daoCoche.save(coche);
		return c;
	}

	public boolean borrar(int id) {
		if (daoCoche.findById(id).isPresent()) {
			return true;
		}
		return false;
	}
}
