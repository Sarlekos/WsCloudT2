package resteurekacoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EjercicioEurekaCocheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioEurekaCocheApplication.class, args);
	}

}
