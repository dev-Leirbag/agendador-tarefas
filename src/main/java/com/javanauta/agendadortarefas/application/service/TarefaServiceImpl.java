package com.javanauta.agendadortarefas.application.service;

import com.javanauta.agendadortarefas.adapters.in.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.adapters.in.mapper.ITarefasConverter;
import com.javanauta.agendadortarefas.adapters.in.mapper.TarefaUpdateConverter;
import com.javanauta.agendadortarefas.adapters.in.service.ITarefasService;
import com.javanauta.agendadortarefas.adapters.out.entity.TarefasEntity;
import com.javanauta.agendadortarefas.application.domain.TarefasDomain;
import com.javanauta.agendadortarefas.application.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas.application.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.agendadortarefas.application.infrastructure.security.JwtUtil;
import com.javanauta.agendadortarefas.porters.out.ITarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements ITarefasService {

    private final ITarefasRepository tarefasRepository;
    private final ITarefasConverter converter;
    private final TarefaUpdateConverter updateConverter;
    private final JwtUtil jwtUtil;

    @Override
    public TarefasDTORecords gravarTarefas(TarefasDTORecords dto, String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        TarefasDTORecords dtoFinal = new TarefasDTORecords(null, dto.nomeTarefa(), dto.descricao(),
                LocalDateTime.now(), dto.dataEvento(), email, null, StatusNotificacaoEnum.PENDENTE);

        TarefasDomain domain = tarefasRepository.gravarTarefa(
                converter.paraDomain(dtoFinal));

        return converter.paraDto(domain);
    }

    @Override
    public List<TarefasDTORecords> buscaListaDeTarefasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {

        List<TarefasDomain> domainLista = tarefasRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial, dataFinal,
                StatusNotificacaoEnum.PENDENTE);

        return converter.paraListaDto(domainLista);

    }

    @Override
    public List<TarefasDTORecords> buscaTarefasPorEmail(String token) {
        String email = jwtUtil.extractUsername(token.substring(7));

        List<TarefasDomain> domainLista = tarefasRepository.findByEmail(email);

        return converter.paraListaDto(domainLista);
    }

    @Override
    public void deletaTarefaPorId(String id) {
        try {
            tarefasRepository.deletaTarefaPorId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id da tarefa não encontrado " + id);
        }
    }

    @Override
    public TarefasDTORecords alteraStatusNotificacao(StatusNotificacaoEnum status, String id) {
        try {
            TarefasDomain domain = tarefasRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            domain.setStatusNotificacaoEnum(status);
            return converter.paraDto(tarefasRepository.gravarTarefa(domain));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar status da tarefa " + e.getCause());
        }
    }

    @Override
    public TarefasDTORecords updateTarefas(TarefasDTORecords dto, String id) {
        try {
            TarefasDomain domain = tarefasRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Id da tarefa não encontrado " + id));

            TarefasEntity entity = converter.paraEntity(domain);

            updateConverter.updateTarefas(dto, entity);

            TarefasDomain domainFinal = converter.paraDomain(entity);

            return converter.paraDto(tarefasRepository.gravarTarefa(domainFinal));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao atualizar a tarefa " + e.getCause());
        }
    }
}
