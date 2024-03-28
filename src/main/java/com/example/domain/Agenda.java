package com.example.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "agenda")
@Entity(name = "Agenda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_Barbeiro")
    private Barbeiro idBarbeiro;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente idCliente;

    @Column(unique = true)
    private LocalDateTime dataCortes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barbeiro getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Barbeiro idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDataCortes() {
        return dataCortes;
    }

    public void setDataCortes(LocalDateTime dataCortes) {
        this.dataCortes = dataCortes;
    }
}
