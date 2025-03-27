package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patrions")
public class Patrions {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String contacto;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
