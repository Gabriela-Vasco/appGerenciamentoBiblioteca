package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.LinkOption;
import java.time.LocalDate;

@Getter
@Setter
public class Revista extends Item {
    private String volume, numero, editora, localPublicacao;
    private LocalDate anoPublicacao;

    @Override
    public String toString() {
        return "Revista{" +
                super.toString() +
                "volume='" + volume + '\'' +
                ", numero='" + numero + '\'' +
                ", editora='" + editora + '\'' +
                ", localPublicacao='" + localPublicacao + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }
}
