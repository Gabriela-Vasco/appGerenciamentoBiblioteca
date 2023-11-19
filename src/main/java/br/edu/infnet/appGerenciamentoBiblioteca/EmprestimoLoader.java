package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Emprestimo;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Item;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmprestimoLoader implements ApplicationRunner {
    private Map<String, Emprestimo> mapa = new HashMap<String, Emprestimo>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //leitura do arquivo texto

        FileReader file = new FileReader("files/emprestimos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            //preenchimento do objeto
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId(campos[0]);
            emprestimo.setUsuario(new Usuario(campos[2] + campos[2], campos[1], campos[2], campos[3]));
            emprestimo.setStatus(Boolean.valueOf(campos[2]));
            emprestimo.setListaItems(new ArrayList<Item>());
            emprestimo.setDataEmprestimo(LocalDateTime.now());
            emprestimo.setDataDevolucaoPrevista(emprestimo.getDataEmprestimo().plusDays(7));
            emprestimo.setDataDevolucaoReal(emprestimo.getDataEmprestimo().plusDays(7));

            //inclusão do objeto no map
            mapa.put(emprestimo.getId(), emprestimo);

            linha = leitura.readLine();
        }

        for (Emprestimo emprestimo : mapa.values()) {
            System.out.println("EMPRESTIMO " + emprestimo);
        }

        leitura.close();
    }
}
