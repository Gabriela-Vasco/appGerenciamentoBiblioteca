package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String id;
    private boolean disponibilidade;
    private String titulo;

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
