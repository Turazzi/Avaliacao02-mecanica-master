package com.example.TrabalhoCarlao02.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMecanico(

        @NotBlank
        String mecanico,

        Integer experiencia
) { }
