package br.com.codenation.evento.service;

import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    //@Autowired
    //private CategoriaService categoriaService;

    //@Autowired
    //private AvaliacaoService avaliacaoService;

    @Override
    public List<Evento> findAll(Pageable pageable) {
        return this.eventoRepository.findAll(pageable).getContent();
    }

    //@Override
   // public List<Evento> findByCategoria(Long idCategoria) {
        //Categoria categoria = this.categoriaService.findById(idCategoria).get();
        //return this.eventoRepository.findByCategorias(categoria);
    //}

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
    public List<Evento> findByNome(String nome, Pageable pageable) {
        return this.eventoRepository.findByTituloContaining(nome, pageable).getContent();
    }

    @Override
    public List<Evento> findByNomeCategoria(String nomeCategoria) {
        return this.eventoRepository.findByNomeCategoria(nomeCategoria);
    }

    @Override
    public List<Evento> findComCategorias() {
        return this.eventoRepository.findComCategoria();
    }

    @Override
    public Evento findByMaiorMediaAvaliacao() {
        return this.eventoRepository.findComAvaliacao().stream().
                collect(Collectors.maxBy(Comparator.comparingInt(Evento::getMediaAvaliacoes))).get();
    }
}
