
package br.modelos;

import com.google.gson.annotations.SerializedName;

class Microrregiao {
    private int id;
    private String nome;
    @SerializedName("mesorregiao")
    private Mesorregiao mesorregiao;   

    // Métodos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Mesorregiao getMesorregiao() {
        return mesorregiao;
    }
    
}
