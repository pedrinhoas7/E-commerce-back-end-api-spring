package com.ondadoacai.apiCadastro;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

//HABILITA A INTERFACE SWAGGER
@EnableSwagger2

@SpringBootApplication
public class ApiCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroApplication.class, args);
	}

}
