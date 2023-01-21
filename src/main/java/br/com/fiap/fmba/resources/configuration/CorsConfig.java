package br.com.fiap.fmba.resources.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		String[] allowedOrigins = new String[] { 
				"https://fmba-frontend-web.herokuapp.com",
				"https://fmba-frontend-web2.herokuapp.com",
				"https://fmba-frontend-react.herokuapp.com",
				"https://fmba-frontend-angular.herokuapp.com",
				"http://localhost:4200", 
				"http://localhost:4500",
				"http://localhost:8080",
				"http://localhost:9080"};
		
		for(String allowedOrigin : allowedOrigins) {			
			registry.addMapping("/**")
				.allowedOrigins(allowedOrigin)
				.allowedMethods("*")
				.maxAge(3600L)
				.allowedHeaders("*")
				.exposedHeaders("Authorization")
				.allowCredentials(true);
		}
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
 
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
