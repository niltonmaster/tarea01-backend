package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages= {"com.mitocode.controller"})
public class Tarea01BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tarea01BackendApplication.class, args);
		System.out.println("gol");
	}

}
