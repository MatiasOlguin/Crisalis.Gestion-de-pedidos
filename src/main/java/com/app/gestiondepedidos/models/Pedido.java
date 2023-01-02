package com.app.gestiondepedidos.models;

import com.app.gestiondepedidos.enums.Estado;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date createAt;

    private Estado estado;

    @Column(name = "monto_total")
    private Double montoTotal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Persona persona;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="pedido_id")
    private List<Item> items;

    public Pedido(){
        this.items= new ArrayList<Item>();
    }

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        Double total=0.0;
        int tamanio=items.size();

        for(int i=0;i<tamanio;i++){
            total+=items.get(i).calcularTotal();
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);
    }
}
