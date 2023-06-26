package br;

import br.API.PesquisaMunicipios;
import br.API.PesquisaUf;
import br.modelos.Municipio;
import br.modelos.UF;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Pesquisa {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Criação de um objeto Scanner para leitura de entrada do usuário
        Scanner leitura = new Scanner(System.in);

        // Criação de um objeto PesquisaUf para obter a lista de estados
        PesquisaUf pesquisaUf = new PesquisaUf();
        List<UF> estados = pesquisaUf.getUfs();
        System.out.println(estados.toString());

        // Loop principal que solicita ao usuário um UF para exibir os municípios correspondentes
        boolean acabou = false;
        while (!acabou) {
            try{
                System.out.println("Digite um UF para ver seus municípios: (ou tt para sair)");
                String uf = leitura.nextLine().toUpperCase();
                if (uf.equalsIgnoreCase("tt")) {
                    break;
                }
                boolean ufEncontrado = false;
                for (UF estado : estados) {
                    if (estado.getSigla().equalsIgnoreCase(uf)) {
                        ufEncontrado = true;
                        // Criação de um objeto PesquisaMunicipios para obter a lista de municípios do UF fornecido
                        PesquisaMunicipios pesquisaMunicipios = new PesquisaMunicipios();
                        List<Municipio> cidades = pesquisaMunicipios.getMunicipios(uf);
                        System.out.println(cidades);
                        break;
                    }
                }

                if (!ufEncontrado) {
                    System.out.println("UF inválido. Tente novamente.");
                }
                
                
        }catch(Exception e){
                System.out.println("Digite um UF válido");
        }
        }
    }
}
