package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Jornal.class, name = "Jornal"),
        @JsonSubTypes.Type(value = Revista.class, name = "Revista"),
        @JsonSubTypes.Type(value = Livro.class, name = "Livro")
})
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean disponibilidade;
    private String titulo;

    @ManyToMany(mappedBy = "listaItems")
    @JsonBackReference
    private List<Emprestimo> emprestimos;

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", titulo='" + titulo + '\'';
    }
}
