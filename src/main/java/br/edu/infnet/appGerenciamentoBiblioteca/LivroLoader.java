package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Livro;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(3)
public class LivroLoader implements ApplicationRunner {
    @Autowired
    private LivroService livroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/livros.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            Livro livro = new Livro();
            livro.setDisponibilidade(Boolean.valueOf(campos[1]));
            livro.setTitulo(campos[2]);
            livro.setAutor(campos[3]);
            livro.setEditora(campos[4]);
            livro.setSinopse(campos[5]);
            livro.setGenero(campos[6]);
            livro.setAnoPublicacao(campos[7]);
            livro.setEdicao(Integer.valueOf(campos[8]));

            livroService.incluir(livro);

            linha = leitura.readLine();
        }

        for (Livro livro : livroService.obterLista()) {
            System.out.println("LIVRO " + livro);
        }

        leitura.close();
    }
}
