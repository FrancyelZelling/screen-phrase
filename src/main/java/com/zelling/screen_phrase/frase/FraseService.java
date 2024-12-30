package com.zelling.screen_phrase.frase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repository;

    public Frase retornarFrase(){
        Frase frase = new Frase("rocky", "teste", "rocky asap", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.9BPDlvHHp_8vhgkcxa9SrQAAAA%26pid%3DApi&f=1&ipt=8634639f41c2fc7409bd8c1e414170c434925b78f5bd322fd375e2a2e05c120d&ipo=images");
        return frase;
    }

    public void criarFrase(Frase frase){
        Frase novaFrase = new Frase(
                frase.getTitulo(),
                frase.getFrase(),
                frase.getPersonagem(),
                frase.getPoster()
        );

        try{
            repository.save(frase);
        } catch (Exception e) {
            throw new RuntimeException("não foi possível criar uma frase no banco de dados. Erro: " + e.getLocalizedMessage());
        }

        System.out.println(
                "frase: " + frase.getFrase() +
                ", titulo: " + frase.getTitulo() +
                ", personagem: " + frase.getPersonagem() +
                ", poster: " + frase.getPoster()
        );
    }
}
