package me.dio.decola_tech_2025;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL")})
@SpringBootApplication(scanBasePackages = "me.dio.decola_tech_2025")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
