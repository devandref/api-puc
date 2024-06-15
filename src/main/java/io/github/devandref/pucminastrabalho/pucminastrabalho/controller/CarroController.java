package io.github.devandref.pucminastrabalho.pucminastrabalho.controller;

import io.github.devandref.pucminastrabalho.pucminastrabalho.model.Carro;
import io.github.devandref.pucminastrabalho.pucminastrabalho.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarroController {

    @Autowired
    private CarroService carroService;

    @QueryMapping
    public List<Carro> carros() {
        return carroService.listarCarros();
    }

    @QueryMapping
    public Carro carro(Long id) {
        return carroService.obterCarroPorId(id);
    }

    @QueryMapping
    public List<Carro> carrosPorMarca(String marca) {
        return carroService.obterCarrosPorMarca(marca);
    }

    @QueryMapping
    public List<Carro> carrosPorModelo(String modelo) {
        return carroService.obterCarrosPorModelo(modelo);
    }

    @QueryMapping
    public List<Carro> carrosPorAno(int ano) {
        return carroService.obterCarrosPorAno(ano);
    }

    @QueryMapping
    public List<Carro> carrosPorAnoMaiorQue(int ano) {
        return carroService.obterCarrosPorAnoMaiorQue(ano);
    }
}