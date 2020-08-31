package com.wm.lotto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	private static final String corsHost = "http://localhost:3000";
	
	public static void main(String[] args) {
		log.info("======Begin App WM-LOTTERY-APP======");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/tokenlogin/checkTokenIsExpire").allowedOrigins(corsHost);
				registry.addMapping("/tokenlogin/checkThisToken").allowedOrigins(corsHost);
				registry.addMapping("/tokenlogin/checkThisTokenByTkUid").allowedOrigins(corsHost);
				registry.addMapping("/tokenlogin/testPost01").allowedOrigins(corsHost);//Test
				
				registry.addMapping("/login_app/login").allowedOrigins(corsHost);
				registry.addMapping("/login_app/login_func").allowedOrigins(corsHost);
				registry.addMapping("/login_app/logout_proc").allowedOrigins(corsHost);
				
				registry.addMapping("/roles/getAllRolesIsActiveByUserId").allowedOrigins(corsHost);
				
				registry.addMapping("/roundConfigure/getCurrentActiveRoundConfigure").allowedOrigins(corsHost);

				registry.addMapping("/testCallApi/testPost01").allowedOrigins(corsHost);//Test
			}
		};
	}
}
