package com.hackatona.epidemia.entity;

import android.os.Parcelable;

import java.io.Serializable;

public class DoencaCoordenada implements Serializable {

    private String nome;
    private boolean isEpidemia;
    private int quantidade;

    public DoencaCoordenada(String nome, boolean isEpidemia, int quantidade) {
        this.nome = nome;
        this.isEpidemia = isEpidemia;
        this.quantidade = quantidade;
    }

    public DoencaCoordenada(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEpidemia() {
        return isEpidemia;
    }

    public void setEpidemia(boolean epidemia) {
        isEpidemia = epidemia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Doença: " + getNome() + '\n' +
                "Casos ocorridos: " + getQuantidade();
    }
}
