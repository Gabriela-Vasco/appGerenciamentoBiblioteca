package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.LinkOption;
import java.time.LocalDate;

@Getter
@Setter
public class Revista extends Item {
    private String volume, numero, editora, titulo, localPublicacao;
    private LocalDate anoPublicacao;
}
