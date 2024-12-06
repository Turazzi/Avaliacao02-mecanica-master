package com.example.TrabalhoCarlao02.response;

import com.example.TrabalhoCarlao02.model.Conserto;
import com.example.TrabalhoCarlao02.model.Mecanico;
import com.example.TrabalhoCarlao02.model.Veiculo;

public record DadosDetalhamentoConserto(

        Integer id,
        String entrada,
        String saida,
        Mecanico mecanico,
        Veiculo veiculo){

    public DadosDetalhamentoConserto (Conserto conserto) {
        this(conserto.getId(), conserto.getEntrada(), conserto.getSaida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }
}

