package br.com.codenation.evento.service;

import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

     @Override
    public List<Evento> findAll(Pageable pageable) {
         return this.eventoRepository.findAll(pageable).getContent();
    }

    public Page<Evento> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");

        return eventoRepository.search(
                searchTerm.toLowerCase(),
                pageRequest);
    }

    @Override
    public Optional<Evento> findById(Long id) {
         return eventoRepository.findById(id);
    }

    @Override
    public Evento save(Evento evento) {
        return this.eventoRepository.save(evento);
    }

    @Override
    public void deleteById(Long id) {
         this.eventoRepository.deleteById(id);
    }

    @Override
    public List<Evento> findByDescricao(String descricao, Pageable pageable) {
        return this.eventoRepository.findByDescricao(descricao,pageable);
    }

    @Override
    public Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable) {
        return this.eventoRepository.findByDescricaoContaining(descricao,pageable);
    }

    @Override
    public List<Evento> findByErrorLevel(ErrorLevel level,Pageable pageable) {
        return this.eventoRepository.findByErrorLevel(level,pageable);
    }

}
