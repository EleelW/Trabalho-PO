package br.API;

import br.modelos.Municipio;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Collator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PesquisaMunicipios {
    public List<Municipio> getMunicipios(String uf) {
        
       
        
        // Fazendo Requests dos dados para a API
        String urlMunicipio = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + uf + "/municipios";
        URI enderecoMunicipio = URI.create(urlMunicipio);
        HttpRequest requestMunicipio = HttpRequest.newBuilder(enderecoMunicipio).build();
        
        
        try {
            // Envio da requisição HTTP GET para obter a lista de municípios
            HttpResponse<String> responseMunicipio = HttpClient
                    .newHttpClient()
                    .send(requestMunicipio, HttpResponse.BodyHandlers.ofString());
            
            // Configuração do objeto Gson para realizar a desserialização do JSON
            Gson gsonMunicipio = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            
            // Utilização do TypeToken para obter o tipo genérico List<Municipio>
            TypeToken<List<Municipio>> tokenMunicipio = new TypeToken<List<Municipio>>() {};
            List<Municipio> cidades = gsonMunicipio.fromJson(responseMunicipio.body(), tokenMunicipio.getType());
            
            Collections.sort(cidades);

        
            return cidades;
        } catch (JsonSyntaxException | IOException | InterruptedException e) {
            // Se ocorrer uma exceção durante a requisição ou desserialização, uma RuntimeException é lançada
            throw new RuntimeException("Não consegui obter o Município a partir desse UF.");
        }
    }
}
