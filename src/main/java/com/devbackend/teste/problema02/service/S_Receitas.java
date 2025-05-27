package com.devbackend.teste.problema02.service;

import com.devbackend.teste.problema02.model.responses.ApiReceitasResponse;
import com.devbackend.teste.problema02.model.requests.ForkifyJson;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class S_Receitas {
    private final WebClient webClient;

    public S_Receitas(WebClient.Builder webClientBuilder) {
        // Cria um WebClient com a URL base igual a URL da API do Forkify
        this.webClient = webClientBuilder.baseUrl("https://forkify-api.herokuapp.com/api").build();
    }

    /**
     * Devolve todas as receitas encontradas no Forkify para o respectivo prato passado nos parãmetros.
     * @param prato String com o nome do prato
     * @return Um objeto contendo o nome do prato e as informações de cada receita fonecidas pela API
     */
    public ApiReceitasResponse getReceitasPrato(String prato) {
        try {
            // Gera uma chamada GET para a URL base + o caminho de search com o nome do prato
            ForkifyJson jsonResponse = webClient.get()
                    .uri("/search?q=" + prato)
                    .retrieve()
                    .bodyToMono(ForkifyJson.class) // Devolve especificamente só um objeto JSON
                    .block();

            assert jsonResponse != null;

            // Gera uma classe customizada de resposta com as informações da API
            return new ApiReceitasResponse(
                    prato,
                    jsonResponse.getCount(),
                    jsonResponse.getRecipes()
            );
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
