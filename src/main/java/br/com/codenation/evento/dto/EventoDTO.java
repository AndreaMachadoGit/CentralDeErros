package br.com.codenation.evento.dto;

import br.com.codenation.evento.model.ErrorLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventoDTO {

    private Long id;
    private String descricao;
    private Long quantidade;
    private ErrorLevel errorLevel;
    private LocalDateTime data;
    private String origem;

}
