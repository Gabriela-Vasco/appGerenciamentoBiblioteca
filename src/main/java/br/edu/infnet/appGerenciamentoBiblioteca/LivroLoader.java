package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Livro;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class LivroLoader implements ApplicationRunner {
    private Map<String, Livro> mapa = new HashMap<String, Livro>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //leitura do arquivo texto

        FileReader file = new FileReader("files/livros.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            //preenchimento do objeto
            Livro livro = new Livro();
            livro.setId(campos[0]);
            livro.setDisponibilidade(Boolean.valueOf(campos[1]));
            livro.setTitulo(campos[2]);
            livro.setAutor(campos[3]);
            livro.setEditora(campos[4]);
            livro.setSinopse(campos[5]);
            livro.setAnoPublicacao(campos[6]);
            livro.setEdicao(Integer.valueOf(campos[7]));


            //inclusão do objeto no map
            mapa.put(livro.getId(), livro);

            linha = leitura.readLine();
        }

        for (Livro livro : mapa.values()) {
            System.out.println("Livro " + livro);
        }

        leitura.close();
    }
}
