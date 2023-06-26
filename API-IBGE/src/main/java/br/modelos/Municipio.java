package br.modelos;

import br.modelos.Microrregiao;
import com.google.gson.annotations.SerializedName;
import java.text.Collator;

public class Municipio implements Comparable<Municipio>{
    @SerializedName("id")
    private int id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("microrregiao")
    private Microrregiao microrregiao;

    //métodos

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Microrregiao getMicrorregiao() {
        return microrregiao;
    }
    
    public String getUF(){
        return microrregiao.getMesorregiao().getUF().getSigla();
    }
    
    public String getRegiao(){
        return microrregiao.getMesorregiao().getUF().getRegiao().getNome();
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Municipio o) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.SECONDARY);
        return collator.compare(this.nome, o.getNome());
    }
}
