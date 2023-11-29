package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private double multa = 0.0;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> listaEmprestimos = new ArrayList<>();


    public Usuario(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Usuario(){

    }

    public void setMulta() {
        if (getListaEmprestimos() != null) {
            for (Emprestimo emprestimo : getListaEmprestimos()) {
                if (emprestimo.isAtrasado() || emprestimo.getDataDevolucaoReal().isAfter(emprestimo.getDataDevolucaoPrevista())) {
                    this.multa = this.multa + 1.50;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", id='" + id + '\'' +
                ", multa='" + multa + '\'' +
                '}';
    }
}
