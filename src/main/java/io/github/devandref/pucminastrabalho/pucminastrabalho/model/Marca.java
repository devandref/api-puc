package io.github.devandref.pucminastrabalho.pucminastrabalho.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Marca {

    private Integer id;
    private String marca;
    private String modelo;
    private String placa;
    @JsonFormat(pattern = "yyyy")
    private LocalDate anoFabricacao;
    @JsonFormat(pattern = "yyyy")
    private LocalDate anoModelo;

}
