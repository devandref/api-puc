package io.github.devandref.pucminastrabalho.pucminastrabalho.model;

import io.github.devandref.pucminastrabalho.pucminastrabalho.model.dto.ConsumoCombustivelDTO;

import java.time.LocalDateTime;
import java.util.UUID;


public class ConsumoCombustivel {

    private UUID id;
    private LocalDateTime data;
    private Double valor;
    private String tipo;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static ConsumoCombustivel dtoToEntity(ConsumoCombustivelDTO consumoCombustivelDTO) {
        ConsumoCombustivel consumoCombustivel = new ConsumoCombustivel();
        consumoCombustivel.setTipo(consumoCombustivelDTO.getTipoCombustivel());
        consumoCombustivel.setId(UUID.randomUUID());
        consumoCombustivel.setData(LocalDateTime.now());
        consumoCombustivel.setValor(consumoCombustivelDTO.getValor());
        return consumoCombustivel;
    }
}
