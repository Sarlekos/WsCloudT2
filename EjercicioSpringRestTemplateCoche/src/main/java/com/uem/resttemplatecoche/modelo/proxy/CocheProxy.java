package com.uem.resttemplatecoche.modelo.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uem.resttemplatecoche.modelo.entidad.Coche;

@Service
public class CocheProxy {

	@Autowired
	private RestTemplate restTemplate;
	// Constante con la URL del servicio rest al que vamos a acceder
	public static final String URL_COCHE = "http://SpringRestCoche/coche/";

	public List<Coche> listar() {

		ResponseEntity<Coche[]> response = restTemplate.getForEntity(URL_COCHE, Coche[].class);

		Coche[] arrayCoche = response.getBody();
		List<Coche> lista = Arrays.asList(arrayCoche);

		return lista;
	}

	public Coche obtener(int id) {

		String cocheResourceUrl = URL_COCHE + id;
		ResponseEntity<Coche> response = restTemplate.getForEntity(cocheResourceUrl, Coche.class);

		return response.getBody();
	}

	public Coche alta(Coche coche) {

		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);
		Coche cCreada = restTemplate.postForObject(URL_COCHE, requestBody, Coche.class);

		return cCreada;
	}

	public Coche modificar(Coche coche) {

		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);
		ResponseEntity<Coche> response = restTemplate.exchange(URL_COCHE + coche.getId(), HttpMethod.PUT, requestBody,
				Coche.class);

		return response.getBody();
	}

	public void borrar(int id) {

		restTemplate.delete(URL_COCHE + id);
	}

}
