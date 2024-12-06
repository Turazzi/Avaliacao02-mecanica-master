package com.example.TrabalhoCarlao02.model;

import com.example.TrabalhoCarlao02.response.DadosAtualizacaoConserto;
import com.example.TrabalhoCarlao02.dto.DadosCadastroConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "consertos")
@Entity(name = "conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String entrada;
    private String saida;

    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.ativo = true;
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }


    public void atualizarInformacoes(DadosAtualizacaoConserto dados, Conserto conserto) {

        if(dados.saida() != null) {
            this.saida = dados.saida();
        }
        if(dados.mecanico().mecanico() != null){
            conserto.getMecanico().atualizarNomeMecanico(dados.mecanico());
        }
        if(dados.mecanico().experiencia() != null) {
            conserto.getMecanico().atualizarAnosExperiencia(dados.mecanico().experiencia());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
