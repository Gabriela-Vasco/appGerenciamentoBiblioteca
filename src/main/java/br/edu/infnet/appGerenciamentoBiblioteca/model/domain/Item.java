package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    private String id;
    private boolean disponibilidade;
    private String titulo;

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", titulo='" + titulo + '\'';
    }
}
