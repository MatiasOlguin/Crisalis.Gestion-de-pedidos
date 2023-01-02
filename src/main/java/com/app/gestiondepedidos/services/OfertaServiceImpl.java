package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Oferta;
import com.app.gestiondepedidos.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfertaServiceImpl implements IOfertaService{
    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    @Transactional(readOnly = true)
    public Oferta findById(Long id) {
        return ofertaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Oferta save(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ofertaRepository.deleteById(id);
    }

    @Override
    public List<Oferta> findAllProductos() {
        return ofertaRepository.findAllProductos();
    }

    @Override
    public List<Oferta> findAllServicios() {return ofertaRepository.findAllServicios();}
}
