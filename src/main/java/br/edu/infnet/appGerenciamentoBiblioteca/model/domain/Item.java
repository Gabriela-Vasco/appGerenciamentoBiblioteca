package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", titulo='" + titulo + '\'';
    }
}
