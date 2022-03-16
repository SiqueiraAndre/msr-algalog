package com.algaworks.algalog.api.controller;

import lombok.RequiredArgsConstructor;
import com.algaworks.algalog.api.assembler.OcorrenciaAssembler;
import com.algaworks.algalog.api.dto.OcorrenciaDTO;
import com.algaworks.algalog.api.dto.request.OcorrenciaRequest;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private final RegistroOcorrenciaService registroOcorrenciaService;
    private final BuscaEntregaService buscaEntregaService;
    private final OcorrenciaAssembler assembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(
            @PathVariable Long entregaId,
            @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest
    ) {
        var ocorrenciaRegistrada = registroOcorrenciaService.registrar(
                entregaId,
                ocorrenciaRequest.getDescricao()
        );

        return assembler.toDTO(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDTO> listar(@PathVariable Long entregaId) {
        var entrega = buscaEntregaService.buscar(entregaId);

        return assembler.toCollectionDTO(entrega.getOcorrencias());
    }

}
