package com.proyecto.empresa.enums;

public enum EState {
    ACTIVE(1),
    INACTIVE(2),
    DELETED(3);

    private final int valor;

    EState(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static EState fromInt(int value) {
        for (EState state : EState.values()) {
            if (state.valor == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid Status value: " + value);
    }
}
