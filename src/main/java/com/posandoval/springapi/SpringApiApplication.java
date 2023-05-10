package com.posandoval.springapi;

import com.posandoval.springapi.dto.Persona;
import com.posandoval.springapi.repository.PersonaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(SpringApiApplication.class, args);

		PersonaRepository repository =context.getBean(PersonaRepository.class);

		Persona persona1=new Persona(null,"Paul","Sandoval",25);
		Persona persona2=new Persona(null,"Omar","Hidalgo",25);
		Persona persona3=new Persona(null,"Adry","Alcarraz",27);
		Persona persona4=new Persona(null,"Adry","Sandoval",27);
		Persona persona5=new Persona(null,"Paul","Alcarraz",28);

		repository.save(persona1);
		repository.save(persona2);
		repository.save(persona3);
		repository.save(persona4);
		repository.save(persona5);
	}

}
