package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Revista;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
@Order(4)
public class RevistaLoader implements ApplicationRunner {
    @Autowired
    private RevistaService revistaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/revistas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            Revista revista = new Revista();
            revista.setDisponibilidade(Boolean.valueOf(campos[1]));
            revista.setTitulo(campos[2]);
            revista.setVolume(campos[3]);
            revista.setNumero(campos[4]);
            revista.setEditora(campos[5]);
            revista.setLocalPublicacao(campos[6]);
            revista.setAnoPublicacao(LocalDate.parse(campos[7]));

            revistaService.incluir(revista);

            linha = leitura.readLine();
        }

        for (Revista revista : revistaService.obterLista()) {
            System.out.println("REVISTA " + revista);
        }

        leitura.close();
    }
}
