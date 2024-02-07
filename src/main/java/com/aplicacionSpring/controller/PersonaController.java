package com.aplicacionSpring.controller;

import com.aplicacionSpring.entities.Persona;
import com.aplicacionSpring.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    @GetMapping
    public String listarPersonas(Model model) {
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("personas",personas);
        return "listar";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioDeNuevaPersona(Model model){
        model.addAttribute("personas",new Persona());
        model.addAttribute("accion","/personas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    public String guardarNuevaPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model){
        Persona persona = personaService.obtenerPorId(id);
        model.addAttribute("persona",persona);
        model.addAttribute("action","/personas/editar"+id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actulizarPersona(@PathVariable Long id, @ModelAttribute Persona persona){
        personaService.actualizarPersona(id,persona);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}
