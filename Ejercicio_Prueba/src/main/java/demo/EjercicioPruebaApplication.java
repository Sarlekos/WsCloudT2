package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import demo.modelo.entidad.*;

@SpringBootApplication
@ImportResource("classpath:bean.xml")
public class EjercicioPruebaApplication {

	public static ApplicationContext context = null;

	public static void main(String[] args) {
		context = SpringApplication.run(EjercicioPruebaApplication.class, args);

		Cliente c = context.getBean("cliente", Cliente.class);
		Direccion d = context.getBean("direccion", Direccion.class);
		Pedido p = context.getBean("pedido", Pedido.class);
		c.setNombre("Pepe");
		c.setDni("2435536F");
		d.setCiudad("Madrid");
		d.setVia("calle la peseta");
		c.setDireccion(d);
		p.setFecha("Mañana");
		p.setTamaño(50);
		c.setPedido(p);

		System.out.println(c);
	}

}
