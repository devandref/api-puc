package io.github.devandref.pucminastrabalho.pucminastrabalho.controller;

import io.github.devandref.pucminastrabalho.pucminastrabalho.model.ConsumoCombustivel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsumoController {

    private List<ConsumoCombustivel> consumoList = new ArrayList<>();

    @GetMapping("/consumos")
    public List<ConsumoCombustivel> consumoCombustivels() {
        return this.consumoList;
    }

    @PostMapping("/consumos")
    public ResponseEntity saveCombustivel(@RequestMapping ) {

    }
}
