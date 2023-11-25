package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.*;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class EmprestimoLoader implements ApplicationRunner {
    @Autowired
    private EmprestimoService emprestimoService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/emprestimos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        Emprestimo emprestimo = null;

        while(linha != null){
            campos = linha.split(";");

            switch (campos[0]){
                case "E":
                    emprestimo = new Emprestimo();
                    emprestimo.setUsuario(new Usuario(campos[1], campos[2], campos[3]));
                    emprestimo.setAtrasado(Boolean.valueOf(campos[4]));
                    emprestimo.setListaItems(new ArrayList<>());
                    emprestimo.setDataEmprestimo(LocalDateTime.now());
                    emprestimo.setDataDevolucaoPrevista(emprestimo.getDataEmprestimo().plusDays(7));
                    emprestimo.setDataDevolucaoReal(emprestimo.getDataEmprestimo().plusDays(7));

                    emprestimoService.incluir(emprestimo);
                    break;

                case "J":
                    Jornal jornal = new Jornal();
                    jornal.setDisponibilidade(Boolean.valueOf(campos[1]));
                    jornal.setTitulo(campos[2]);
                    jornal.setVolume(campos[3]);
                    jornal.setNumero(campos[4]);
                    jornal.setLocalPublicacao(campos[5]);
                    jornal.setDataPublicacao(LocalDate.parse(campos[6]));

                    emprestimo.getListaItems().add(jornal);
                    break;

                case "L":
                    Livro livro = new Livro();
                    livro.setDisponibilidade(Boolean.valueOf(campos[1]));
                    livro.setTitulo(campos[2]);
                    livro.setAutor(campos[3]);
                    livro.setEditora(campos[4]);
                    livro.setSinopse(campos[5]);
                    livro.setGenero(campos[6]);
                    livro.setAnoPublicacao(campos[7]);
                    livro.setEdicao(Integer.valueOf(campos[8]));

                    emprestimo.getListaItems().add(livro);
                    break;

                case "R":
                    Revista revista = new Revista();
                    revista.setDisponibilidade(Boolean.valueOf(campos[1]));
                    revista.setTitulo(campos[2]);
                    revista.setVolume(campos[3]);
                    revista.setNumero(campos[4]);
                    revista.setEditora(campos[5]);
                    revista.setLocalPublicacao(campos[6]);
                    revista.setAnoPublicacao(LocalDate.parse(campos[7]));

                    emprestimo.getListaItems().add(revista);
                    break;

                default:
                    break;
            }

            emprestimoService.incluir(emprestimo);

            linha = leitura.readLine();
        }

        for (Emprestimo emprestimo1 : emprestimoService.obterLista()) {
            System.out.println("EMPRESTIMO " + emprestimo1);
        }

        leitura.close();
    }
}
