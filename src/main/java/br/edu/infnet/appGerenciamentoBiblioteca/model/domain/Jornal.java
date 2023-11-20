package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Jornal extends Item {
    private String volume, numero, localPublicacao;
    private LocalDate dataPublicacao;

    @Override
    public String toString() {
        return "Jornal{" +
                super.toString() +
                "volume='" + volume + '\'' +
                ", numero='" + numero + '\'' +
                ", localPublicacao='" + localPublicacao + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
