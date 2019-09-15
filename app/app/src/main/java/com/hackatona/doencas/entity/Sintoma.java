package com.hackatona.doencas.entity;

import com.google.gson.annotations.SerializedName;

public class Sintoma {

    @SerializedName("nome")
    private String nome;

    public Sintoma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
