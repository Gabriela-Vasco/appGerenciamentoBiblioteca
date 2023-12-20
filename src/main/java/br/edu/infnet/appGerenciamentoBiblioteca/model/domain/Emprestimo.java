package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean atrasado;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucaoPrevista;
    private LocalDateTime dataDevolucaoReal;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Item> listaItems = new ArrayList<>();


    public Emprestimo(boolean atrasado, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucaoPrevista, LocalDateTime dataDevolucaoReal, Usuario usuario) {
        this.atrasado = atrasado;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.usuario = usuario;
        this.listaItems = new ArrayList<>();
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
