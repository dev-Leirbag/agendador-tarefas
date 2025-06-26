package com.javanauta.agendadortarefas.adapters.out.repository;

import com.javanauta.agendadortarefas.adapters.in.mapper.ITarefasConverter;
import com.javanauta.agendadortarefas.adapters.out.entity.TarefasEntity;
import com.javanauta.agendadortarefas.application.domain.TarefasDomain;
import com.javanauta.agendadortarefas.application.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas.porters.out.ITarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TarefasRepositoryImpl implements ITarefasRepository {

    private final ITarefasJpaRepository tarefasJpaRepository;
    private final ITarefasConverter converter;


    @Override
    public TarefasDomain gravarTarefa(TarefasDomain domain) {
        TarefasEntity entitySalvo = tarefasJpaRepository.save(
                converter.paraEntity(domain));

        return converter.paraDomain(entitySalvo);
    }

    @Override
    public List<TarefasDomain> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataInicial,
                                                                               LocalDateTime dataFinal,
                                                                               StatusNotificacaoEnum status) {
        List<TarefasEntity> entityLista = tarefasJpaRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial,
                dataFinal, status);

        return converter.paraListaDomainn(entityLista);
    }

    @Override
    public List<TarefasDomain> findByEmail(String email) {
        List<TarefasEntity> entityLista = tarefasJpaRepository.findByEmailUsuario(email);

        return converter.paraListaDomainn(entityLista);

    }

    @Override
    public void deletaTarefaPorId(String id) {
        tarefasJpaRepository.deleteById(id);
    }

    @Override
    public Optional<TarefasDomain> findById(String id) {
        return tarefasJpaRepository.findById(id).map(converter::paraDomain);
    }
}
