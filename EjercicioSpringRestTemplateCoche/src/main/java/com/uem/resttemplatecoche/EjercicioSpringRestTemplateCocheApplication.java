package com.uem.resttemplatecoche;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.uem.resttemplatecoche.modelo.entidad.Coche;
import com.uem.resttemplatecoche.modelo.proxy.CocheProxy;

@SpringBootApplication
@EnableDiscoveryClient
public class EjercicioSpringRestTemplateCocheApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioSpringRestTemplateCocheApplication.class, args);
		
		CocheProxy cProxy = context.getBean("cocheProxy",CocheProxy.class);
	
		System.out.println("LISTAR");
		List<Coche> listaCoches = cProxy.listar();
		System.out.println(listaCoches);
		
		System.out.println("OBTENER");
		Coche c2 = cProxy.obtener(10);
		System.out.println(c2);
		
		/*Coche c1 = new Coche();
		c1.setMarca("Porche");
		c1.setMatricula("3333 CCC");
		c1.setModelo("911");
		c1.setPotencia("470cv");
		
		System.out.println("ALTA");
		c1 = cProxy.alta(c1);
		System.out.println(c1);
		
		c2 = new Coche();
		c2.setMarca("Mercedes");
		c2.setMatricula("4444 BBB");
		c2.setModelo("CLA");
		c2.setPotencia("250cv");
		
		System.out.println("MODIFICAR");
		Coche c3 = cProxy.modificar(c2);
		
		System.out.println(c3);
		
		System.out.println("BORRAR");
		cProxy.borrar(10);
		System.out.println("Coche borrado");
		
		System.out.println("LISTAR");
		listaCoches = cProxy.listar();
		System.out.println(listaCoches);*/
	}

}
