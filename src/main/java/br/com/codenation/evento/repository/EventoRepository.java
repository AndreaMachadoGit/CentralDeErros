package br.com.codenation.evento.repository;


import br.com.codenation.categoria.model.Categoria;
import br.com.codenation.evento.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface EventoRepository extends CrudRepository<Evento, Long> {

    Page<Evento> findAll(Pageable pageable);

    List<Evento> findByTitulo(String titulo);

    Page<Evento> findByTituloContaining(String titulo, Pageable pageable);

    List<Evento> findByCategorias(Categoria categoria);

    @Query("from Evento livro where livro.categorias is not empty")
    List<Evento> findComCategoria();


    @Query(value = "select * from LIVRO livro " +
            "INNER JOIN LIVRO_CATEGORIA cl " +
            "ON livro.id = cl.id_livro " +
            "INNER JOIN categoria c " +
            "ON c.id = cl.id_categoria " +
            "where c.nome like %:nomeCategoria%", nativeQuery = true)
    List<Evento> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

    @Query("from Evento livro where livro.avaliacoes is not empty")
    List<Evento> findComAvaliacao();
}
