package com.API.first.model;

import jakarta.persistence.*;
        import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "colecao")
public class ColecaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private productModel produtoId;
    @Column(length = 50, nullable = false)
    private Date dataValorValido;
    @Column(nullable = false)
    private long precoSugerido;
    @Column(length = 25, nullable = false)
    private String codigoColecao;
}
