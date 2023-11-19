package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private double multa;
    private List<Emprestimo> listaEmprestimos = new ArrayList<>();

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
