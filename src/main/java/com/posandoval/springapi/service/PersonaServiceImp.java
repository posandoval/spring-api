package com.posandoval.springapi.service;

import com.posandoval.springapi.dto.Persona;
import com.posandoval.springapi.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService {
//public class PersonaServiceImp{

    //Atributos

    private PersonaRepository personaRepository;
    private Logger logg= LoggerFactory.getLogger(PersonaServiceImp.class);

    //Constructor
    public PersonaServiceImp(PersonaRepository personaRepository){
        this.personaRepository=personaRepository;
    }

    //Methots CRUD

    public List<Persona> findAll(){
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Long id){
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> findByName(String name) {
        return personaRepository.findByName(name);
    }

    @Override
    public List<Persona> findByLastname(String lastname) {
        return personaRepository.findByLastname(lastname);
    }

    @Override
    public List<Persona> findByAge(Integer age) {
        return personaRepository.findByAge(age);
    }

    //Create Method
    @Override
      public Persona create(Persona persona) {
        Persona personaTemp= personaRepository.save(persona);
    return personaTemp;
    }

    @Override
    public void deleteById(Long id) {
        if(id==null || id<=0){
            logg.warn("Trying to delete a person with wrong id");
        }
        try {
            personaRepository.deleteById(id);
        }catch(Exception e){
            logg.warn("Error trying to delete a person by id {}",id,e);
            }
    }
    @Override
    public void deleteByAge(Integer age){
        List<Persona> listDel=findByAge(age);
        try{
            personaRepository.deleteAll(listDel);
        }catch(Exception e){
            logg.warn("Error to deleteByAge");
        }
    }

    @Override
    public void deleteByName(String name) {
    List<Persona> listDel=personaRepository.findByName(name);
        try {
        personaRepository.deleteAll(listDel);
    }catch(Exception e) {
        logg.warn("Error to deleteByName");
    }
    }

    @Override
    public void deleteByLastname(String lastname) {
        List<Persona>listDel=personaRepository.findByLastname(lastname);
        try {
            personaRepository.deleteAll(listDel);
        } catch(Exception e){
            logg.warn("Error to deleteByLastnames");
        }
    }




}//End class