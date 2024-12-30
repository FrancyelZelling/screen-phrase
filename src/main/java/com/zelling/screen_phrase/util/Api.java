package com.zelling.screen_phrase.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zelling.screen_phrase.Serie.Serie;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Optional;

public class Api {
    private final String endereco = "https://www.omdbapi.com/?t=";
    private final String apiKey = "&apikey=6585022c";
    private ObjectMapper mapper = new ObjectMapper();

    public Optional<Serie> getSerie(String name){

        var newName = name.replace(" ", "+");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.endereco + newName + this.apiKey))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();

        try {
            return Optional.ofNullable(mapper.readValue(json, Serie.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
