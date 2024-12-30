package com.zelling.screen_phrase.frase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series/frases")
public class FraseController {
    @Autowired
    private FraseService service;

    @GetMapping
    @ResponseBody
    public Frase retornarFrase(){
        return service.retornarFrase();
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public void criarFrase(@RequestBody Frase frase){
        service.criarFrase(frase);
    }
}
