package com.posandoval.springapi.service;

import com.posandoval.springapi.dto.Persona;

import java.util.List;
import java.util.Optional;


public interface PersonaService {

    List<Persona> findAll();
    Optional<Persona> findById(Long id);
    List<Persona> findByName(String name);
    List<Persona> findByLastname(String lastname);
    List<Persona> findByAge(Integer age);
    Persona create(Persona persona);
    void deleteById(Long id);
    void deleteByName(String name);
    void deleteByAge(Integer age);
    void deleteByLastname(String lastname);
}
