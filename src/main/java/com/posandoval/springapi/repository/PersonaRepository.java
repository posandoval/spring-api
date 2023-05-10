package com.posandoval.springapi.repository;

import com.posandoval.springapi.dto.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    //List<Persona> findAll();
    //Optional<Persona> findById(Long id);
    List<Persona> findByName(String name);
    List<Persona> findByLastname(String lastname);
    List<Persona> findByAge(Integer age);

    }
