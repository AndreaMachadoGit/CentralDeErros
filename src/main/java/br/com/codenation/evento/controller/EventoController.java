package br.com.codenation.evento.controller;

import br.com.codenation.controller.advice.ResourceNotFoundException;
import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.service.EventoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @ApiOperation("Cria um novo evento de erro")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento criado com sucesso")})
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Atualiza um evento de erro")
    public ResponseEntity<Evento> update(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista todos os eventos de erros da APP")
    public Iterable<Evento> findAll(@PathParam("descricao") String descricao, Pageable pageable) {
        if (descricao != null) {
            return this.eventoService.findByDescricao(descricao, pageable);
        }
        return this.eventoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um evento pelo Id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não localizado"), @ApiResponse(code = 200, message = "Evento localizado")})
    public ResponseEntity<Evento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Evento>(this.eventoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um evento")
    public void delete(@PathVariable("id") Long id) {
        this.eventoService.deleteById(id);
    }

    @GetMapping("/byErrorLevel/{level}")
    @ApiOperation("Busca uma lista de eventos de erros pelo nível do erro (ERROR, WARNING, INFO)")
    public List<Evento> findByLevel(@PathVariable("level") ErrorLevel level, Pageable pageable) {
        return this.eventoService.findByErrorLevel(level,pageable);
    }

    @GetMapping("/search")
    @ApiOperation("Efetua a busca no banco de dados pelo conteúdo dos campos Descrição ou Log ou Origem")
    public Page<Evento> search(
            @RequestParam("searchTerm") String searchTerm,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return eventoService.search(searchTerm, page, size);

    }



}
