package tech.klok.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DesafioEstagioApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(DesafioEstagioApi2Application.class, args);
	}

}
