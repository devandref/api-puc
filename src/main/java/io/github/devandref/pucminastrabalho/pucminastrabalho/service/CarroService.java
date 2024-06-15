package io.github.devandref.pucminastrabalho.pucminastrabalho.service;

import io.github.devandref.pucminastrabalho.pucminastrabalho.model.Carro;
import io.github.devandref.pucminastrabalho.pucminastrabalho.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro cadastrarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public Carro obterCarroPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    public List<Carro> obterCarrosPorMarca(String marca) {
        return carroRepository.findAll().stream()
                .filter(carro -> carro.getMarca().equalsIgnoreCase(marca))
                .toList();
    }

    public List<Carro> obterCarrosPorModelo(String modelo) {
        return carroRepository.findAll().stream()
                .filter(carro -> carro.getModelo().equalsIgnoreCase(modelo))
                .toList();
    }

    public List<Carro> obterCarrosPorAno(int ano) {
        return carroRepository.findAll().stream()
                .filter(carro -> carro.getAno() == ano)
                .toList();
    }

    public List<Carro> obterCarrosPorAnoMaiorQue(int ano) {
        return carroRepository.findAll().stream()
                .filter(carro -> carro.getAno() > ano)
                .toList();
    }
}
