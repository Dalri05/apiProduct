package com.API.first.model;

import com.API.first.enums.ClienteEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private int cliente_id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ClienteEnum situacao = ClienteEnum.ATIVO;
    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ClienteEnum TIPO = ClienteEnum.TIPO_CLIENTE;
}
