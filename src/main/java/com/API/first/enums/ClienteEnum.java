package com.API.first.enums;

public enum ClienteEnum {
    INATIVO(0),
    ATIVO(1),
    TIPO_CLIENTE(30),
    TIPO_PROSPECT(99);

    private final int codigo;

    ClienteEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
