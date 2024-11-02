package com.example.TrabalhoCarlao02.conserto;

import com.example.TrabalhoCarlao02.mecanico.DadosCadastroMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(

        @NotNull
        Integer id,
        String saida,
        DadosCadastroMecanico mecanico

) {
}


