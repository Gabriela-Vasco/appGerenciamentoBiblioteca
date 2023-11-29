package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.*;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.EmprestimoService;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.ItemService;
import jakarta.transaction.Transactional;
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
import java.util.List;

@Component
@Order(5)
public class EmprestimoLoader implements ApplicationRunner {
    @Autowired
    private EmprestimoService emprestimoService;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/emprestimos2.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        Emprestimo emprestimo = null;

        while (linha != null) {
            campos = linha.split(";");

            switch (campos[0]) {
                case "J":
                    Jornal jornal = new Jornal();
                    jornal.setId(Integer.valueOf(campos[1]));

                    emprestimo.getListaItems().add(jornal);
                    break;

                case "L":
                    Livro livro = new Livro();
                    livro.setId(Integer.valueOf(campos[1]));

                    emprestimo.getListaItems().add(livro);
                    break;

                case "R":
                    Revista revista = new Revista();
                    revista.setId(Integer.valueOf(campos[1]));

                    emprestimo.getListaItems().add(revista);
                    break;

                case "E":
                    Usuario usuario = new Usuario();
                    usuario.setId(Integer.valueOf(campos[1]));

                    emprestimo = new Emprestimo();
                    emprestimo.setUsuario(usuario);
                    emprestimo.setAtrasado(Boolean.valueOf(campos[4]));
                    emprestimo.setListaItems(new ArrayList<>());
                    emprestimo.setDataEmprestimo(LocalDateTime.now());
                    emprestimo.setDataDevolucaoPrevista(emprestimo.getDataEmprestimo().plusDays(7));
                    emprestimo.setDataDevolucaoReal(emprestimo.getDataEmprestimo().plusDays(7));

                    emprestimoService.incluir(emprestimo);
                    break;

                default:
                    break;
            }

            emprestimoService.incluir(emprestimo);

            linha = leitura.readLine();
        }

        for (Emprestimo emprestimo1 : emprestimoService.obterLista()) {
            emprestimo1.getListaItems().size();
            System.out.println("EMPRESTIMO " + emprestimo1);
        }

        leitura.close();
    }
}
