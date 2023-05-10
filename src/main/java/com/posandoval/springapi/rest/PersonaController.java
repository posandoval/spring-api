package com.posandoval.springapi.rest;

import com.posandoval.springapi.dto.Persona;
import com.posandoval.springapi.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    Logger logg= LoggerFactory.getLogger(PersonaController.class);

    //Constructor
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    //Metodos

    /**
     * http://lolcalhost:8080/api/findAll
     * @return
     */
    @GetMapping("/api/findAll")
    public ResponseEntity<List<Persona>> findAll(){
        return ResponseEntity.ok(personaService.findAll());
    }

    /**
     * http://lolcalhost:8080/api/findById/id
     * @param id
     * @return
     */
    @GetMapping("/api/findById/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id){
        Optional<Persona> perOptional=personaService.findById(id);
            if(!perOptional.isPresent()){
                logg.info("FindById Not found");
            return ResponseEntity.notFound().build();
            }
        return ResponseEntity.ok(perOptional.get());
    }

    /**
     * http://lolcalhost:8080/api/findByName/name
     * @param name
     * @return
     */
    @GetMapping("/api/findByName/{name}")
    public ResponseEntity<List<Persona>> findByName(@PathVariable String name){
        List<Persona> personaList= personaService.findByName(name);
        if(personaList.isEmpty()) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personaList);
    }

    /**
     * http://lolcalhost:8080/api/findByLastname/lastname
     * @param lastname
     * @return
     */
    @GetMapping("/api/findByLastname/{lastname}")
    public ResponseEntity<List<Persona>> findByLastname(@PathVariable String lastname){
        List<Persona> personaList=personaService.findByLastname(lastname);
        if(personaList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personaList);
    }

    /**
     * http://lolcalhost:8080/api/findByAge/age
     * @param age
     * @return
     */
    @GetMapping("/api/findByAge/{age}")
    public ResponseEntity<List<Persona>> findByAge(@PathVariable Integer age){
        List<Persona> personaList=personaService.findByAge(age);
                if(personaList.isEmpty()){
                    return ResponseEntity.notFound().build();
                }
        return ResponseEntity.ok(personaService.findByAge(age));
    }

    //Create Method

    /**
     * http://lolcalhost:8080/api/create
     * @param persona
     * @return
     */
    @PostMapping("/api/create")
    public ResponseEntity<Persona> create(@RequestBody Persona persona){
        if(persona.getId()!=null){
            logg.warn("Trying to create a person with ID");
            return  ResponseEntity.badRequest().build();
        }
        logg.info("Created a new Person");
        Persona optional= personaService.create(persona);
        return  ResponseEntity.ok(optional);
    }

    //Delete Methods

    /**
     * http://lolcalhost:8080/api/deleteById/id
     * @param id
     * @return
     */
    @DeleteMapping("/api/deleteById/{id}")
    public ResponseEntity<Persona> deleteById(@PathVariable Long id){

        if(!personaService.findById(id).isPresent()){
            logg.warn("Trying to delete a Person with non exist Id");
            return ResponseEntity.badRequest().build();
        }

        personaService.deleteById(id);
        logg.info("Delete a person with id: "+id);
        return ResponseEntity.noContent().build();
    }

    /**
     * http://lolcalhost:8080/api/deleteByName/name
     * @param name
     * @return
     */
    @DeleteMapping("/api/deleteByName/{name}")
    public ResponseEntity<Persona> deleteByName(@PathVariable String name){
        if(personaService.findByName(name).isEmpty()){
           logg.warn("Trying to delete a person with non exist name");
           return ResponseEntity.badRequest().build();
        }
        personaService.deleteByName(name);
        logg.info("Delete persons with names"+name);
        return ResponseEntity.noContent().build();
    }

    /**
     * http://lolcalhost:8080/api/deleteByLastname/lastname
     * @param lastname
     * @return
     */
    @DeleteMapping("/api/deleteByLastname/{lastname}")
    public ResponseEntity<Persona> deleteByLastname(@PathVariable String lastname){
        if(personaService.findByLastname(lastname).isEmpty()){
            logg.warn("Trying to delete a person with a non exist Lastname");
            return ResponseEntity.badRequest().build();
        }
        personaService.deleteByLastname(lastname);
        logg.info("Delete persons by lastnames:  "+lastname);
        return ResponseEntity.noContent().build();
    }

    /**
     * http://lolcalhost:8080/api/deleteByAge/age
     * @param age
     * @return
     */
    @DeleteMapping("/api/deleteByAge/{age}")
    public ResponseEntity<Persona> deleteByAge(@PathVariable Integer age) {
        if (personaService.findByAge(age).isEmpty()) {
            logg.warn("Trying to delete a person with a non exist Age");
            return ResponseEntity.badRequest().build();
        }
        personaService.deleteByAge(age);
        logg.info("Delete persons by Age:  "+age);
        return ResponseEntity.noContent().build();
    }

    //Post Method

    /**
     * http://lolcalhost:8080/api/update
     * @param persona
     * @return
     */
    @PutMapping("/api/update")
    public ResponseEntity<Persona> update(@RequestBody Persona persona){
        if(persona.getId()==null){
            logg.warn("Trying to update a Person with null Id");
            return ResponseEntity.badRequest().build();
        }
        if(!personaService.findById(persona.getId()).isPresent()){
            logg.warn("Trying to update a non existent Person ");
            return ResponseEntity.badRequest().build();
        }
        Persona personaTemp=personaService.create(persona);
        return ResponseEntity.ok(personaTemp);
    }

}//EndClass