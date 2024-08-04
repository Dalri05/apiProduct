package com.API.first.model;

import com.API.first.enums.ClienteEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vendas")
public class VendasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;
    @Column(length = 50, nullable = false)
    private long valor;
    @Column(length = 50, nullable = false)
    private Date dataDeCompra = new Date();
}
