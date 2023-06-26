package br.modelos;

import com.google.gson.annotations.SerializedName;


public class UF implements Comparable<UF>{
    @SerializedName ("id")
    private final int id;
    @SerializedName ("nome")
    private final String nome;
    @SerializedName("sigla")
    private final String sigla;
    @SerializedName("regiao")
    private Regiao regiao;


    // Construtor e outros métodos
    public UF(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }
    public Regiao getRegiao() {
        return regiao;
    }
    
    public int getId() {
        return id;
    }

    

    public String getNome() {
        return nome;
    }



    public String getSigla() {
        return sigla;
    }
 
    @Override
    public String toString(){
        return nome+ " ("+sigla + ")";
    }

   

    @Override
    public int compareTo(UF o) {
        return this.nome.compareTo(o.getNome());
    }

    
   
}
