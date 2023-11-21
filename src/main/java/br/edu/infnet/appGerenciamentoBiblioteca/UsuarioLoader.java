package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            Usuario usuario = new Usuario();
            usuario.setNome(campos[0]);
            usuario.setCpf(campos[1]);
            usuario.setEmail(campos[2]);
            usuario.setId(campos[1] + campos[1]);

            usuarioService.incluir(usuario);

            linha = leitura.readLine();
        }

        for (Usuario usuario : usuarioService.obterLista()) {
            System.out.println("USUARIO " + usuario);
        }

        leitura.close();
    }
}
