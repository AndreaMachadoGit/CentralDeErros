package br.com.codenation.evento.mapper;

import br.com.codenation.evento.dto.eventoDTO;
import br.com.codenation.evento.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface eventoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "quantidade", target = "quantidade"),
            @Mapping(source = "errorLevel", target = "errorLevel"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "origem", target = "origem")
    })

    eventoDTO map(Evento evento);

    List<eventoDTO> map(List<Evento> eventos);

}
