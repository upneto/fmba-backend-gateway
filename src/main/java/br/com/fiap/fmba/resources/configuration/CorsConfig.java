package br.com.fiap.fmba.resources.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**")
		 	.allowedOrigins("https://fmba-frontend-web.herokuapp.com")
		 	.allowedMethods("*")
		 	.maxAge(3600L)
		 	.allowedHeaders("*")
		 	.exposedHeaders("Authorization")
		 	.allowCredentials(true);
		 
		 registry.addMapping("/**")
		 	.allowedOrigins("http://localhost:4500")
		 	.allowedMethods("*")
		 	.maxAge(3600L)
		 	.allowedHeaders("*")
		 	.exposedHeaders("Authorization")
		 	.allowCredentials(true);
    }
}
