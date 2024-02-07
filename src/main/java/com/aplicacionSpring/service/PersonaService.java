package com.aplicacionSpring.service;

import com.aplicacionSpring.entities.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> obtenerTodas();

    Persona obtenerPorId(long id);

    Persona crearPersona(Persona persona);

    Persona actualizarPersona(long id, Persona persona);

    void eliminarPersona(Long id);
}
