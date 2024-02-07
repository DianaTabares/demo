package com.aplicacionSpring.service.impl;

import com.aplicacionSpring.entities.Persona;
import com.aplicacionSpring.repository.PersonaRepository;
import com.aplicacionSpring.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> obtenerTodas(){
        return personaRepository.findAll();
    }
    @Override
    public Persona obtenerPorId(long id){
        return personaRepository.findById(id).orElse(null);
    }
    @Override
    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }
    @Override
    public Persona actualizarPersona(long id, Persona persona){
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if(personaOptional.isPresent()){
            Persona personaBD = personaOptional.get();
            personaBD.setNombre(persona.getNombre());
            personaBD.setEdad(persona.getEdad());
            return personaRepository.save(personaBD);
        } else {
            return null;
        }
    }
    @Override
    public void eliminarPersona(Long id){
        personaRepository.deleteById(id);
    }
}
