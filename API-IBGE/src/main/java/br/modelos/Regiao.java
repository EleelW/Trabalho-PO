
package br.modelos;

import com.google.gson.annotations.SerializedName;


class Regiao {
    @SerializedName("id")
    private int id;
    @SerializedName("sigla")
    private String sigla;
    @SerializedName("nome")
    private String nome;

    //métodos
    public int getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
}
