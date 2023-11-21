package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Emprestimo {
    private String id;
    private boolean atrasado;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucaoPrevista;
    private LocalDateTime dataDevolucaoReal;
    private Usuario usuario;
    private List<Item> listaItems = new ArrayList<>();


    public Emprestimo(String id, boolean atrasado, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucaoPrevista, LocalDateTime dataDevolucaoReal, Usuario usuario, List<Item> listaItems) {
        this.id = id;
        this.atrasado = atrasado;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.usuario = usuario;
        this.listaItems = listaItems;
    }

    public Emprestimo(){

    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id='" + id + '\'' +
                ", usuario=" + usuario +
                ", atrasado=" + atrasado +
                ", listaItems=" + listaItems+
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoReal=" + dataDevolucaoReal +
                '}';
    }
}
