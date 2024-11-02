package com.example.TrabalhoCarlao02.controller;


import com.example.TrabalhoCarlao02.conserto.*;
import com.example.TrabalhoCarlao02.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repo;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarConserto(@RequestBody @Valid DadosCadastroConserto dados, UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repo.save(conserto);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping
    public ResponseEntity listar(Pageable paginacao) {
        return ResponseEntity.ok(repo.findAll(paginacao));
    }

    @GetMapping
    @RequestMapping("dadosespecificos")
    public ResponseEntity listarDadosEspecificios(@PageableDefault( size=10, sort={"entrada","saida"} ) Pageable paginacao) {

        var pagina = repo.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList();

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Integer id) {
        Optional<Conserto> consertoOptional = repo.findById(id);

        if(consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repo.getReferenceById(dados.id());

        conserto.atualizarInformacoes(dados, conserto);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Integer id) {
        Conserto conserto = repo.getReferenceById(id);

        conserto.excluir();

        return ResponseEntity.noContent().build();
    }

}
