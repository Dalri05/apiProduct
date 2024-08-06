package com.API.first.enums;

public enum ProdutoEnum {
    INDISPONIVEL(0),
    DISPONIVEL(1);

    private final int codigo;

    ProdutoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
