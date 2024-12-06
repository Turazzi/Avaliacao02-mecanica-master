package com.example.TrabalhoCarlao02.response;

import com.example.TrabalhoCarlao02.model.Conserto;

public record DadosListagemConserto(
        Integer id,
        String entrada,
        String saida,
        String mecanico,
        String veiculo_marca,
        String veiculo_modelo

) {
    public DadosListagemConserto(Conserto conserto) {
        this(conserto.getId(), conserto.getEntrada(), conserto.getSaida(), conserto.getMecanico().getMecanico(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
