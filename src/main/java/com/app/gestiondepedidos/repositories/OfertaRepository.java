package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Oferta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, Long> {
    @Query(value = "SELECT * FROM ofertas WHERE oferta_tipo='producto'", nativeQuery = true)
    public List<Oferta> findAllProductos();

    @Query(value = "SELECT * FROM ofertas WHERE oferta_tipo='servicio'", nativeQuery = true)
    public List<Oferta> findAllServicios();
}

