package br.com.codenation.evento.model;

//import br.com.codenation.categoria.model.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank(message = "A descrição do erro não pode ser vazia")
    private String descricao;

    @Min(0)
    @Max(10)
    @PositiveOrZero
    private Long quantidade;

    private ErrorLevel errorLevel;


    //@ManyToMany
    //@JoinTable(name = "LIVRO_CATEGORIA",
    //        joinColumns = @JoinColumn(name = "idLivro"),
    //        inverseJoinColumns = @JoinColumn(name = "idCategoria"))
    //private List<Categoria> categorias;

    public Evento(String titulo) {
        this.descricao = titulo;
    }

    public Evento() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //public List<Categoria> getCategorias() {
    //    return categorias;
    //}

    //public void setCategorias(List<Categoria> categorias) {
    //    this.categorias = categorias;
    //}


    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    //public Integer getMediaAvaliacoes() {
     //   return this.avaliacoes.stream()
     //           .collect(Collectors.maxBy(Comparator.comparingInt(Avaliacao::getNota))).get().getNota();
    //}

}
