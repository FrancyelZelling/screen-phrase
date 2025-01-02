package com.zelling.screen_phrase.frase;

import com.zelling.screen_phrase.util.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repository;
    private Api api = new Api();

    public Frase retornarFrase(){
        Frase frase = new Frase("rocky", "teste", "rocky asap", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.9BPDlvHHp_8vhgkcxa9SrQAAAA%26pid%3DApi&f=1&ipt=8634639f41c2fc7409bd8c1e414170c434925b78f5bd322fd375e2a2e05c120d&ipo=images");
        return frase;
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
