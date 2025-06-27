package com.javanauta.agendadortarefas.adapters.in.mapper;

import com.javanauta.agendadortarefas.adapters.in.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.adapters.out.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTORecords dto, @MappingTarget TarefasEntity entity);
}
