package com.app.gestiondepedidos.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="servicio")
public class Servicio extends Oferta{
    @Column(name="cargo_soporte")
    private Double cargoSoporte;
    @Column(name="tipo_servicio")
    private String tipo;

    public Double getCargoSoporte() {
        return cargoSoporte;
    }
    public void setCargoSoporte(Double cargoSoporte) {
        this.cargoSoporte = cargoSoporte;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
