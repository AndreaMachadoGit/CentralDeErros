package br.com.codenation.evento.repository;

import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {

    Page<Evento> findAll(Pageable pageable);

    List<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    List<Evento> findByErrorLevel(ErrorLevel errorLevel, Pageable pageable);

    @Query(value = "SELECT * FROM Evento e " +
            "WHERE (LOWER(e.descricao) like %:searchTerm% " +
            "OR LOWER(e.origem) like %:searchTerm%)  ", nativeQuery = true)
    List<Evento> search(@Param("searchTerm") String searchTerm, Pageable pageable);

}
