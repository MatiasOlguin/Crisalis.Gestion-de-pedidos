package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Pedido;
import com.app.gestiondepedidos.models.Persona;
import com.app.gestiondepedidos.services.IPedidoService;
import com.app.gestiondepedidos.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pedidos")
@SessionAttributes("pedido")
public class PedidoController {
    @Autowired
    IPedidoService pedidoService;

    @Autowired
    private IPersonaService personaService;


    @GetMapping("/form/{personaId}")
    public String crear(@PathVariable(value="personaId") Long personaId, Model model, RedirectAttributes flash){
        Persona persona=personaService.findById(personaId);
        if(persona==null){
            flash.addFlashAttribute("error","La persona no existe en la base de datos");
            return "redirect:/listar";
        }
        Pedido pedido=new Pedido();
        pedido.setPersona(persona);

        model.addAttribute("pedido",pedido);
        model.addAttribute("titulo","Crear pedido");
        return "/pedidos/form";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de pedidos");
        model.addAttribute("pedidos", pedidoService.findAll());
        return "/pedidos/listar";
    }
}
