package de.myrnet.testshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TestshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestshowApplication.class, args);
	}

}
