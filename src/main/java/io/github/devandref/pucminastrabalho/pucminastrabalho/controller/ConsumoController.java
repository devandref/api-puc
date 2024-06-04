package io.github.devandref.pucminastrabalho.pucminastrabalho.controller;

import io.github.devandref.pucminastrabalho.pucminastrabalho.model.ConsumoCombustivel;
import io.github.devandref.pucminastrabalho.pucminastrabalho.model.dto.ConsumoCombustivelDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ConsumoController {

    private List<ConsumoCombustivel> consumoList = new ArrayList<>();

    @GetMapping("/consumos")
    public List<ConsumoCombustivel> consumoCombustivels() {
        return this.consumoList;
    }

    @GetMapping("/consumos/{id}")
    public ResponseEntity<ConsumoCombustivel> findById(@PathVariable String id) {
        Optional<ConsumoCombustivel> consumoCombustivelOptional = this.consumoList.stream().filter(consumoCombustivel -> consumoCombustivel.getId().toString().equals(id)).findFirst();
        if (consumoCombustivelOptional.isPresent()) {
            return ResponseEntity.ok(consumoCombustivelOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/consumos/{id}")
    public ResponseEntity updateById(@PathVariable String id, @RequestBody ConsumoCombustivelDTO consumoCombustivelDTO) {
        Optional<ConsumoCombustivel> consumoCombustivelOptional = this.consumoList.stream().filter(consumoCombustivel -> consumoCombustivel.getId().toString().equals(id)).findFirst();
        if (consumoCombustivelOptional.isPresent()) {
            this.consumoList.remove(consumoCombustivelOptional.get());
            ConsumoCombustivel consumoCombustivel = consumoCombustivelOptional.get();
            if (consumoCombustivelDTO.getTipoCombustivel() != null) {
                consumoCombustivel.setTipo(consumoCombustivelDTO.getTipoCombustivel());
            }
            if (consumoCombustivelDTO.getValor() != null) {
                consumoCombustivel.setValor(consumoCombustivelDTO.getValor());
            }
            this.consumoList.add(consumoCombustivel);
            return ResponseEntity.ok(consumoCombustivel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/consumos")
    public ResponseEntity saveCombustivel(@RequestBody ConsumoCombustivelDTO consumoCombustivelDTO, UriComponentsBuilder uriComponent) {
        ConsumoCombustivel consumoCombustivel = ConsumoCombustivel.dtoToEntity(consumoCombustivelDTO);
        this.consumoList.add(consumoCombustivel);
        var uri = uriComponent.path("/consumos/{id}").buildAndExpand(consumoCombustivel.getId()).toUri();
        return ResponseEntity.created(uri).body(consumoCombustivel);
    }

    @DeleteMapping("/consumos/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        Optional<ConsumoCombustivel> consumoCombustivelOptional = this.consumoList.stream().filter(consumoCombustivel -> consumoCombustivel.getId().toString().equals(id)).findFirst();
        if (consumoCombustivelOptional.isPresent()) {
            this.consumoList.remove(consumoCombustivelOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
