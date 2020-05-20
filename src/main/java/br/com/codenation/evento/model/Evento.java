package br.com.codenation.evento.model;

//import br.com.codenation.categoria.model.Categoria;

import org.springframework.data.annotation.CreatedDate;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank(message = "A descrição do evento não pode ser vazia")
    private String descricao;

    @Min(0)
    @PositiveOrZero
    private Long quantidade;

    private ErrorLevel errorLevel;

    @CreatedDate
    private LocalDateTime data;

    @NotNull
    private String log;

    @NotNull
    private String origem;

    public Evento(String descricao) {
        this.descricao = descricao;
    }

    public Evento() {
        super();
    }

}
