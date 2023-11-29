package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean disponibilidade;
    private String titulo;

    @ManyToMany(mappedBy = "listaItems")
    private List<Emprestimo> emprestimos;

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", titulo='" + titulo + '\'';
    }
}
