package com.javanauta.agendadortarefas.porters.out;

import com.javanauta.agendadortarefas.application.domain.TarefasDomain;
import com.javanauta.agendadortarefas.application.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ITarefasRepository {

    TarefasDomain gravarTarefa(TarefasDomain domain);

    List<TarefasDomain> findByDataEventoBetweenAndStatusNotificacaoEnum (LocalDateTime dataInicial, LocalDateTime dataFinal,
                                                                         StatusNotificacaoEnum status);

    List<TarefasDomain> findByEmail(String email);

    @Transactional
    void deletaTarefaPorId (String id);

    Optional<TarefasDomain> findById(String id);

}
