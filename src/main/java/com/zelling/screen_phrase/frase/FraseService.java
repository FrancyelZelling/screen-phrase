package com.zelling.screen_phrase.frase;

import com.zelling.screen_phrase.util.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repository;
    private Api api = new Api();

    public Frase retornarFrase(){
        Random random = new Random();
        List<Frase> fraseList = repository.findAll();
        return fraseList.get(random.nextInt(fraseList.size()));
    }

    public void criarFrase(Frase frase){
        String poster = procurarSeriePoster(frase.getTitulo());

        if(poster.length() < 10) {
            poster = "poster not found";
        }

        Frase novaFrase = new Frase(
                frase.getTitulo(),
                frase.getFrase(),
                frase.getPersonagem(),
                poster
        );

        try{
            repository.save(novaFrase);
            System.out.println("frase salva com sucesso.");
        } catch (Exception e) {
            throw new RuntimeException("não foi possível criar uma frase no banco de dados. Erro: " + e.getLocalizedMessage());
        }

        System.out.println(
                "frase: " + novaFrase.getFrase() +
                ", titulo: " + novaFrase.getTitulo() +
                ", personagem: " + novaFrase.getPersonagem() +
                ", poster: " + novaFrase.getPoster()
        );
    }

    public String procurarSeriePoster(String nome) {
        var serie = api.getSerie(nome);

        if(serie.isPresent()){
            System.out.println(serie.get().poster());
            return serie.get().poster();
        } else {
            return "poster não encontrado";
        }
    }
}
