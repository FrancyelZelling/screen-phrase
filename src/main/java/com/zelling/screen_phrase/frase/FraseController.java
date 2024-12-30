package com.zelling.screen_phrase.frase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
