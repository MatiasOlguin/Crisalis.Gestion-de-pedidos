package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Pedido;
import com.app.gestiondepedidos.models.Persona;

import java.util.List;

public interface IPedidoService {
    public List<Pedido> findAll();
    public Pedido findById(Long id);
    public Pedido save(Pedido pedido);
    public void delete(Long id);
}
