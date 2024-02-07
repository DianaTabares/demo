package com.aplicacionSpring;

import com.aplicacionSpring.entities.Persona;
import com.aplicacionSpring.repository.PersonaRepository;
import com.aplicacionSpring.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionSpringApplication implements CommandLineRunner {
	@Autowired
	private PersonaRepository personaRepository;

	private PersonaService personaService;

	@Autowired
	public static void main(String[] args) {

		SpringApplication.run(AplicacionSpringApplication.class, args);
	}
	@Override
	public void run(String[] args) throws Exception{
		personaService.crearPersona(new Persona(1L,"Christian",17));

		System.out.println("numero de personas:" + personaRepository.count());

	}

}
