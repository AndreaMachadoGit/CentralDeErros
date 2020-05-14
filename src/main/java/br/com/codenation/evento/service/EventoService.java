package br.com.codenation.evento.service;

import br.com.codenation.evento.model.Evento;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<Evento> findAll(Pageable pageable);

    //List<Evento> findByCategoria(Long idCategoria);

    Optional<Evento> findById(Long id);

    Evento save(Evento evento);

    void deleteById(Long id);

    List<Evento> findByNome(String nome, Pageable pageable);

    List<Evento> findByNomeCategoria(String nomeCategoria);

    List<Evento> findComCategorias();

    Evento findByMaiorMediaAvaliacao();

}
