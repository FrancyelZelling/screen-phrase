package com.zelling.screen_phrase.frase;

import org.springframework.stereotype.Service;

@Service
public class FraseService {
    public Frase retornarFrase(){
        Frase frase = new Frase("rocky", "teste", "rocky asap", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.9BPDlvHHp_8vhgkcxa9SrQAAAA%26pid%3DApi&f=1&ipt=8634639f41c2fc7409bd8c1e414170c434925b78f5bd322fd375e2a2e05c120d&ipo=images");
        return frase;
    }
}
