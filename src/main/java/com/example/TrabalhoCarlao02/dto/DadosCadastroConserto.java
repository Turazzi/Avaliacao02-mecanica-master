package com.example.TrabalhoCarlao02.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String entrada,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String saida,

        @NotNull
        @Valid
        DadosCadastroMecanico mecanico,

        @NotNull
        @Valid
        DadosCadastroVeiculo veiculo
) { }
