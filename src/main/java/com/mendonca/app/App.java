package com.mendonca.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mendonca.controller.AplicationController;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AplicationController.class})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
