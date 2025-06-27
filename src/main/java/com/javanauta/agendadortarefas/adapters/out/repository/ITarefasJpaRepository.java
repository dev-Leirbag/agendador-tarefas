package com.javanauta.agendadortarefas.adapters.out.repository;

import com.javanauta.agendadortarefas.adapters.out.entity.TarefasEntity;
import com.javanauta.agendadortarefas.application.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ITarefasJpaRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataInicial, LocalDateTime dataFinal,
                                                                        StatusNotificacaoEnum status);

    List<TarefasEntity> findByEmailUsuario(String email);

}
