
package br.modelos;

import com.google.gson.annotations.SerializedName;


class Mesorregiao {
    private int id;
    private String nome;
    @SerializedName("UF")
    private UF UF;

    // Métodos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Mesorregiao() {
    }

    public UF getUF() {
        return UF;
    }

}
