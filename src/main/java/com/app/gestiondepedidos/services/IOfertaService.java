package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Oferta;

import java.util.List;

public interface IOfertaService {
    public Oferta findById(Long id);
    public Oferta save(Oferta oferta);
    public void delete(Long id);
    public List<Oferta> findAllProductos();
    public List<Oferta> findAllServicios();
}
