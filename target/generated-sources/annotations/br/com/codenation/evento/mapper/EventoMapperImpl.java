package br.com.codenation.evento.mapper;

import br.com.codenation.evento.dto.EventoDTO;
import br.com.codenation.evento.model.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-20T15:16:44-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EventoMapperImpl implements EventoMapper {

    @Override
    public EventoDTO map(Evento evento) {
        if ( evento == null ) {
            return null;
        }

        EventoDTO eventoDTO = new EventoDTO();

        eventoDTO.setData( evento.getData() );
        eventoDTO.setOrigem( evento.getOrigem() );
        eventoDTO.setId( evento.getId() );
        eventoDTO.setQuantidade( evento.getQuantidade() );
        eventoDTO.setDescricao( evento.getDescricao() );
        eventoDTO.setErrorLevel( evento.getErrorLevel() );

        return eventoDTO;
    }

    @Override
    public List<EventoDTO> map(List<Evento> eventos) {
        if ( eventos == null ) {
            return null;
        }

        List<EventoDTO> list = new ArrayList<EventoDTO>( eventos.size() );
        for ( Evento evento : eventos ) {
            list.add( map( evento ) );
        }

        return list;
    }
}
