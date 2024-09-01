package com.API.first.model;

import com.API.first.enums.ProdutoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product")
public class productModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String description;
    @Column(length = 50, nullable = false)
    private Long preco;
    @Column(name = "quantidadeDisponivel", length = 50, nullable = false)
    private String quantidadeDisponivel;
    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProdutoEnum DISPONIBILIDADE;
    @Column(length = 50, nullable = false)
    private Date dataInsercao;
    @Column(name = "product_id")
    private int produtoId;
    @OneToMany(mappedBy = "codigoColecao")
    private List<ColecaoModel> colecoes;
}
