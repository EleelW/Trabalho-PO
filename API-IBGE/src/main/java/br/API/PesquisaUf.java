package br.API;

import br.modelos.UF;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PesquisaUf {
   
    public List<UF> getUfs() throws IOException, InterruptedException {
        
        // Fazendo Requests dos dados para a API
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
        URI endereco = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(endereco).build();

        try {
            // Envio da requisição HTTP GET para obter a lista de estados
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            
            // Utilização do TypeToken para obter o tipo genérico List<UF>
            TypeToken<List<UF>> token = new TypeToken<List<UF>>() {};
            
            // Configuração do objeto Gson para realizar a desserialização do JSON
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            
            // Desserialização da resposta JSON em uma lista de objetos UF
            List<UF> estados = gson.fromJson(response.body(), token.getType());
            
            
            Collections.sort(estados);
            return estados;
        } catch (JsonSyntaxException | IOException | InterruptedException e) {
            // Se ocorrer uma exceção durante a requisição ou desserialização, uma RuntimeException é lançada
            throw new RuntimeException("Não consegui obter os UF.");
        }
    }
}
