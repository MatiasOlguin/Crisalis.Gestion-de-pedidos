package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.services.IOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("producto")
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private IOfertaService ofertaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de Productos");
        model.addAttribute("productos", ofertaService.findAllProductos());
        return "/productos/listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Producto producto = new Producto ();
        model.put("producto", producto);
        model.put("titulo", "Formulario de Producto");
        model.put("botonAccion","Crear Producto");
        return "/productos/form";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model){
        Producto producto = null;

        if(id > 0) {
            producto= (Producto) ofertaService.findById(id);}
        else {
            return "redirect:listar";
        }
        model.put("producto", producto);
        model.put("titulo", "Editar Producto");
        model.put("botonAccion","Editar Producto");
        return "/productos/form";
    }

    @PostMapping("/form")
    public String guardar(Producto producto, SessionStatus status) {
        ofertaService.save(producto);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        if(id>0) {
            ofertaService.delete(id);
        }
        return "redirect:/productos/listar";
    }
}