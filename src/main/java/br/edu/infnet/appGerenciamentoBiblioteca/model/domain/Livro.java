package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Livro {
    private String autor, editora, sinopse, genero, titulo;
    private LocalDate anoPublicacao;
    private int edicao;
}
