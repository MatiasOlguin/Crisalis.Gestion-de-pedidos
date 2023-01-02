package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.services.IOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("servicio")
@RequestMapping("/servicios")

public class ServicioController {
    @Autowired
    private IOfertaService ofertaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de Servicios");
        model.addAttribute("servicios", ofertaService.findAllServicios());
        return "/servicios/listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Servicio servicio = new Servicio ();
        model.put("servicio", servicio);
        model.put("titulo", "Formulario de Servicio");
        model.put("botonAccion","Crear Servicio");
        return "/servicios/form";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model){
        Servicio servicio = null;

        if(id > 0) {
            servicio= (Servicio) ofertaService.findById(id);}
        else {
            return "redirect:listar";
        }
        model.put("servicio", servicio);
        model.put("titulo", "Editar Servicio");
        model.put("botonAccion","Editar Servicio");
        return "/servicios/form";
    }

    @PostMapping("/form")
    public String guardar(Servicio servicio, SessionStatus status) {
        ofertaService.save(servicio);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        if(id>0) {
            ofertaService.delete(id);
        }
        return "redirect:/servicios/listar";
    }
}