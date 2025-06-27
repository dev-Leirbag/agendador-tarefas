package com.javanauta.agendadortarefas.adapters.in.controller;

import com.javanauta.agendadortarefas.adapters.in.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.adapters.in.service.ITarefasService;
import com.javanauta.agendadortarefas.application.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas.application.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
@Tag(name = "Agendador-Tarefas", description = "Agenda as tarefas do usuario")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final ITarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salva a Tarefa", description = "Cria e salva a tarefa do usuario")
    @ApiResponse(responseCode = "200", description = "Tarefa cadastrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTORecords> gravarTarefas(@RequestBody TarefasDTORecords dto,
                                                           @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(dto, token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por data", description = "Busca tarefas por data")
    @ApiResponse(responseCode = "200", description = "Tarefas retornadas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTORecords>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return ResponseEntity.ok(tarefasService.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    @Operation(summary = "Busca tarefas por email", description = "Busca tarefas pelo email do usuario")
    @ApiResponse(responseCode = "200", description = "Tarefas retornadas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTORecords>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token) {
        List<TarefasDTORecords> tarefas = tarefasService.buscaTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por id", description = "Deleta tarefas por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id) {
        tarefasService.deletaTarefaPorId(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera o status da tarefa", description = "Altera o status da tarefa")
    @ApiResponse(responseCode = "200", description = "Status alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTORecords> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                     @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefasService.alteraStatusNotificacao(status, id));
    }

    @PutMapping
    @Operation(summary = "Atualiza as tarefas", description = "Atualiza tarefas")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTORecords> updateTarefas(@RequestBody TarefasDTORecords dto, @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id));
    }
}
