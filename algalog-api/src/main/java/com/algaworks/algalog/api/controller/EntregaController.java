package com.algaworks.algalog.api.controller;

import lombok.RequiredArgsConstructor;
import com.algaworks.algalog.api.assembler.EntregaAssembler;
import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.api.dto.request.EntregaRequest;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.FinalizacaoEntregaService;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/entregas")
public class EntregaController {

    private final EntregaRepository repository;
    private final SolicitacaoEntregaService solicitacaoEntregaService;
    private final FinalizacaoEntregaService finalizacaoEntregaService;
    private final EntregaAssembler assembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(
            @Valid @RequestBody EntregaRequest entregaRequest
    ) {
        var novaEntrega = assembler.toEntity(entregaRequest);
        var entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return assembler.toDTO(entregaSolicitada);
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @GetMapping
    public List<EntregaDTO> listar() {
        return assembler.toCollectionDTO(repository.findAll());
    }

    @GetMapping(path = "/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
        return repository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(assembler.toDTO(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

}
