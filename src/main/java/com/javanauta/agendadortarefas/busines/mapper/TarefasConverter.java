package com.javanauta.agendadortarefas.busines.mapper;

import com.javanauta.agendadortarefas.busines.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTORecords dto);

    TarefasDTORecords paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTORecords> dtos);

    List<TarefasDTORecords> paraListaTarefasDTORecords(List<TarefasEntity> entity);

}
