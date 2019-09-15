package com.hackatona.epidemia.entity;

import com.google.gson.annotations.SerializedName;

public class Sintoma {

    @SerializedName("nome")
    private String nome;

    @SerializedName("idSintoma")
    private int idSintoma;


    public Sintoma(String nome, int idSintoma) {
        this.nome = nome;
        this.idSintoma = idSintoma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }
}
