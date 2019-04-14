package com.mendonca.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mendonca.controller.AplicationController;
import com.mendonca.controller.RestController;
import com.mendonca.services.UserService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AplicationController.class,RestController.class,UserService.class})
@EntityScan("com.mendonca.model")
@EnableJpaRepositories("com.mendonca.repository")
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
