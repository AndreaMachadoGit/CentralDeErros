package br.com.codenation.evento.mapper;

import br.com.codenation.evento.dto.EventoDTO;
import br.com.codenation.evento.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    EventoMapper INSTANCE = Mappers.getMapper( EventoMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "quantidade", target = "quantidade"),
            @Mapping(source = "errorLevel", target = "errorLevel"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "origem", target = "origem")
    })

    EventoDTO map(Evento evento);

    List<EventoDTO> map(List<Evento> eventos);

    //Page<EventoDTO> map(Page<Evento> eventosP);

}
