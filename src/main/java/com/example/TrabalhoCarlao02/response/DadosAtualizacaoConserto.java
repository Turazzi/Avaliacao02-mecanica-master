package com.example.TrabalhoCarlao02.response;

import com.example.TrabalhoCarlao02.dto.DadosCadastroMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(

        @NotNull
        Integer id,
        String saida,
        DadosCadastroMecanico mecanico

) {
}


