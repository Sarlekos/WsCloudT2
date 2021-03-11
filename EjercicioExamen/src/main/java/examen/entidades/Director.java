package examen.entidades;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Director extends Date {
	private int id;
	private String nombre;
	private int edad;
	private int añoDeNacimiento;

	public void añoNacimiento() {
		int añoActual = this.getYear() + 1900;
		int añoNac = añoActual - this.getEdad();
		this.setAñoDeNacimiento(añoNac);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAñoDeNacimiento() {
		return añoDeNacimiento;
	}

	public void setAñoDeNacimiento(int añoDeNacimiento) {
		this.añoDeNacimiento = añoDeNacimiento;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", añoDeNacimiento=" + añoDeNacimiento
				+ "]";
	}

}
