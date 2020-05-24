package br.com.codenation.evento.service;

import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<Evento> findAll(Pageable pageable);

    Optional<Evento> findById(Long id);

    Evento save(Evento evento);

    void deleteById(Long id);

    List<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    List<Evento> findByErrorLevel(ErrorLevel level, Pageable pageable);

    List<Evento> search(String searchTerm,int page, int size);

}
