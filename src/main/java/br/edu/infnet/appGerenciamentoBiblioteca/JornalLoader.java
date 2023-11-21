package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Emprestimo;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Item;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Jornal;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.EmprestimoService;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.JornalService;
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

@Order(4)
@Component
public class JornalLoader implements ApplicationRunner {
    @Autowired
    private JornalService jornalService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/jornais.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            Jornal jornal = new Jornal();
            jornal.setId(campos[0]);
            jornal.setDisponibilidade(Boolean.valueOf(campos[1]));
            jornal.setTitulo(campos[2]);
            jornal.setVolume(campos[3]);
            jornal.setNumero(campos[4]);
            jornal.setLocalPublicacao(campos[5]);
            jornal.setDataPublicacao(LocalDate.parse(campos[6]));

            jornalService.incluir(jornal);

            linha = leitura.readLine();
        }

        for (Jornal jornal : jornalService.obterLista()) {
            System.out.println("JORNAL " + jornal);
        }

        leitura.close();
    }
}
