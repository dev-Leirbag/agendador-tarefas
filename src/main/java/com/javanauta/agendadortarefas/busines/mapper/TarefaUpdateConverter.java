package com.javanauta.agendadortarefas.busines.mapper;

import com.javanauta.agendadortarefas.busines.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTORecords dto, @MappingTarget TarefasEntity entity);
}
