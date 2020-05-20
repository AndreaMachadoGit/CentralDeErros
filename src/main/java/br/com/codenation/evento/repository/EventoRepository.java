package br.com.codenation.evento.repository;


//import br.com.codenation.categoria.model.Categoria;
import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface EventoRepository extends CrudRepository<Evento, Long> {

    Page<Evento> findAll(Pageable pageable);

    List<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    List<Evento> findByErrorLevel(ErrorLevel errorLevel, Pageable pageable);

    @Query("FROM Evento e " +
            "WHERE LOWER(e.descricao) like %:searchTerm% " +
            "OR LOWER(e.origem) like %:searchTerm% " +
            "OR LOWER(e.log) like %:searchTerm% ")
    Page<Evento> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

}
