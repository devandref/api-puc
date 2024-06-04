package io.github.devandref.pucminastrabalho.pucminastrabalho.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ConsumoCombustivel {

    private UUID id;
    private LocalDateTime data;
    private Double valor;
    private Integer tipo;
}
