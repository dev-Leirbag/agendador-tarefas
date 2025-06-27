package com.javanauta.agendadortarefas.adapters.in.mapper;

import com.javanauta.agendadortarefas.adapters.in.dto.TarefasDTORecords;
import com.javanauta.agendadortarefas.adapters.out.entity.TarefasEntity;
import com.javanauta.agendadortarefas.application.domain.TarefasDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITarefasConverter {

    //Para Domain
    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasDomain paraDomain(TarefasDTORecords dtoRecords);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasDomain paraDomain(TarefasEntity entity);

    List<TarefasDomain> paraListaDomain(List<TarefasDTORecords> dtoRecords);

    List<TarefasDomain> paraListaDomainn(List<TarefasEntity> entity);

    //Para Entity
    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraEntity(TarefasDomain domain);

    List<TarefasEntity> paraListaEntity(List<TarefasDomain> domain);

    //ParaDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasDTORecords paraDto(TarefasDomain domain);

    List<TarefasDTORecords> paraListaDto(List<TarefasDomain> domain);

}
