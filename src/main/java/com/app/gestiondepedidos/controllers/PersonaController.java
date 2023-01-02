package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Persona;
import com.app.gestiondepedidos.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("persona")
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de Personas");
        model.addAttribute("personas", personaService.findAll());
        return "/personas/listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Persona persona= new Persona();
        model.put("persona", persona);
        model.put("titulo", "Formulario de Persona");
        model.put("botonAccion","Crear Persona");
        return "/personas/form";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model){
        Persona persona= null;

        if(id > 0) {
            persona=personaService.findById(id);}
        else {
            return "redirect:listar";
        }
        model.put("persona", persona);
        model.put("titulo", "Editar Persona");
        model.put("botonAccion","Editar Persona");
        return "/personas/form";
    }

    @RequestMapping(value="/ver/{id}")
    public String ver(@PathVariable(value="id") Long id, Map<String, Object> model){
        Persona persona= null;

        if(id > 0) {
            persona=personaService.findById(id);}
        else {
            return "redirect:listar";
        }
        model.put("persona", persona);
        model.put("titulo", "Ver Persona");
        return "/personas/ver";
    }

    @PostMapping("/form")
    public String guardar(Persona persona, SessionStatus status) {
        personaService.save(persona);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        if(id>0) {
            personaService.delete(id);
        }
        return "redirect:/personas/listar";
    }
}
