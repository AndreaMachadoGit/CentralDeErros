package br.com.codenation.evento.controller;

import br.com.codenation.controller.advice.ResourceNotFoundException;
import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.service.EventoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    @ApiOperation("Cria um novo evento")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento criado com sucesso")})
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Evento> update(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista todos os eventos")
    public Iterable<Evento> findAll(@PathParam("nome") String nome, Pageable pageable) {
        if (nome != null) {
            return this.eventoService.findByNome(nome.toString(), pageable);
        }
        return this.eventoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não localizado"), @ApiResponse(code = 200, message = "Evento localizado")})
    public ResponseEntity<Evento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Evento>(this.eventoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.eventoService.deleteById(id);
    }

    //@GetMapping("/byLevel/{level}")
    //public List<Evento> findByLevel(@PathVariable("level") Long level) {
    //    return this.eventoService.findByLevel(level);
    //}

    @GetMapping("/byNomeCategoria/{nome}")
    public List<Evento> findByNomeCategoria(@PathVariable("nome") String nomeCategoria) {
        return this.eventoService.findByNomeCategoria(nomeCategoria);
    }

    @GetMapping("/comCategorias")
    public List<Evento> findComCategoria() {
        return this.eventoService.findComCategorias();
    }

    @GetMapping("/testException")
    public void testException() {
        Integer x = 2 / 0;
    }

}
