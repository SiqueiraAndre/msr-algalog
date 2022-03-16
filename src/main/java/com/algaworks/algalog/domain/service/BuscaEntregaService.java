package com.algaworks.algalog.domain.service;

import lombok.RequiredArgsConstructor;
import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuscaEntregaService {

    private final EntregaRepository repository;

    public Entrega buscar(Long entregaId) {
        return repository
                .findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }

}
