package br.com.fiap.fmba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class FmbaApplication {

	public static void main(String[] args) {
		String env = System.getProperty("env");
		System.out.println("=> ENV = " + env);
		if(env == null) {
			System.getProperties().put("env", "P");
		}
		SpringApplication.run(FmbaApplication.class, args);
	}

}
