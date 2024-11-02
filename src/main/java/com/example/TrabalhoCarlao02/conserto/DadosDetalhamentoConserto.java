package com.example.TrabalhoCarlao02.conserto;

import com.example.TrabalhoCarlao02.mecanico.DadosCadastroMecanico;
import com.example.TrabalhoCarlao02.mecanico.Mecanico;
import com.example.TrabalhoCarlao02.veiculo.DadosCadastroVeiculo;
import com.example.TrabalhoCarlao02.veiculo.Veiculo;

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

