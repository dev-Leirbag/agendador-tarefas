package com.javanauta.agendadortarefas.adapters.in.service;

import com.javanauta.agendadortarefas.adapters.in.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.application.infrastructure.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;
import java.util.List;

public interface ITarefasService {

    TarefasDTORecords gravarTarefas(TarefasDTORecords dto, String token);

    List<TarefasDTORecords> buscaListaDeTarefasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal);

    List<TarefasDTORecords> buscaTarefasPorEmail (String token);

    void deletaTarefaPorId (String id);

    TarefasDTORecords alteraStatusNotificacao(StatusNotificacaoEnum status, String id);

    TarefasDTORecords updateTarefas(TarefasDTORecords dto, String id);

}
