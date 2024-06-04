package io.github.devandref.pucminastrabalho.pucminastrabalho.model.dto;

import io.github.devandref.pucminastrabalho.pucminastrabalho.model.ConsumoCombustivel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SaveConsumoCombustivelDTO {

    private LocalDateTime data;
    private Double valor;
    private Integer tipo;

    public static ConsumoCombustivel dtoToEntity(SaveConsumoCombustivelDTO saveConsumoCombustivelDTO) {
       ConsumoCombustivel consumoCombustivel = new ConsumoCombustivel();

    }

}
