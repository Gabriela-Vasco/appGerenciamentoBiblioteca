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

@Order(5)
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
                    emprestimo.setId(campos[1]);
                    emprestimo.setUsuario(new Usuario(campos[3] + campos[3], campos[2], campos[3], campos[4]));
                    emprestimo.setAtrasado(Boolean.valueOf(campos[5]));
                    emprestimo.setListaItems(new ArrayList<>());
                    emprestimo.setDataEmprestimo(LocalDateTime.now());
                    emprestimo.setDataDevolucaoPrevista(emprestimo.getDataEmprestimo().plusDays(7));
                    emprestimo.setDataDevolucaoReal(emprestimo.getDataEmprestimo().plusDays(7));

                    emprestimoService.incluir(emprestimo);
                    break;

                case "J":
                    Jornal jornal = new Jornal();
                    jornal.setId(campos[1]);
                    jornal.setDisponibilidade(Boolean.valueOf(campos[2]));
                    jornal.setTitulo(campos[3]);
                    jornal.setVolume(campos[4]);
                    jornal.setNumero(campos[5]);
                    jornal.setLocalPublicacao(campos[6]);
                    jornal.setDataPublicacao(LocalDate.parse(campos[7]));

                    emprestimo.getListaItems().add(jornal);
                    break;

                case "L":
                    Livro livro = new Livro();
                    livro.setId(campos[1]);
                    livro.setDisponibilidade(Boolean.valueOf(campos[2]));
                    livro.setTitulo(campos[3]);
                    livro.setAutor(campos[4]);
                    livro.setEditora(campos[5]);
                    livro.setSinopse(campos[6]);
                    livro.setGenero(campos[7]);
                    livro.setAnoPublicacao(campos[8]);
                    livro.setEdicao(Integer.valueOf(campos[9]));

                    emprestimo.getListaItems().add(livro);
                    break;

                case "R":
                    Revista revista = new Revista();
                    revista.setId(campos[1]);
                    revista.setDisponibilidade(Boolean.valueOf(campos[2]));
                    revista.setTitulo(campos[3]);
                    revista.setVolume(campos[4]);
                    revista.setNumero(campos[5]);
                    revista.setEditora(campos[6]);
                    revista.setLocalPublicacao(campos[7]);
                    revista.setAnoPublicacao(LocalDate.parse(campos[8]));

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
