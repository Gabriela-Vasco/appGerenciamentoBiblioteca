package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Livro extends Item {
    private String autor, editora, sinopse, genero, anoPublicacao;
    private int edicao;

    @Override
    public String toString() {
        return "Livro{" +
                super.toString() +
                "autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", genero='" + genero + '\'' +
                ", anoPublicacao='" + anoPublicacao + '\'' +
                ", edicao=" + edicao +
                '}';
    }
}
