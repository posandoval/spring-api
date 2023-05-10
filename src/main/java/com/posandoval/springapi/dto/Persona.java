package com.posandoval.springapi.dto;

import jakarta.persistence.*;

@Entity
@Table(name="sa-persona")
public class Persona {

    //Atributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private Integer age;

    //Constructors
    public Persona(){}

    public Persona(Long id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    //Methods
    public void setId(Long id){this.id=id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public void setAge(Integer age){
        this.age=age;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname(){
        return lastname;
    }

    public Integer getAge(){
        return age;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

}//End class