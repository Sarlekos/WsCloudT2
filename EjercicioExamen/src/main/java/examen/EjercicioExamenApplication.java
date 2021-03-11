package examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import examen.entidades.Actor;
import examen.entidades.Director;
import examen.entidades.Pelicula;

@SpringBootApplication
public class EjercicioExamenApplication {
	public static ApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(EjercicioExamenApplication.class, args);

		Actor actor = context.getBean("actor", Actor.class);
		actor.setEdad(33);
		actor.setId(1);
		actor.setNombre("Julian");

		Director director = context.getBean("director", Director.class);
		director.setNombre("Pepe");
		director.setId(1);
		director.setEdad(47);
		director.añoNacimiento();

		Pelicula pelicula = context.getBean("pelicula", Pelicula.class);
		pelicula.setId(1);
		pelicula.setActor(actor);
		pelicula.setDirector(director);

		System.out.println("\n" + pelicula);
	}

}
