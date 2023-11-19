package br.edu.infnet.appGerenciamentoBiblioteca;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class UsuarioLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //leitura do arquivo texto

        FileReader file = new FileReader("files/usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);
        //preenchimento do objeto
        //inclusão do objeto no map
    }
}
