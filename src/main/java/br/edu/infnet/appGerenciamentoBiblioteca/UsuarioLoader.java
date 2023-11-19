package br.edu.infnet.appGerenciamentoBiblioteca;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class UsuarioLoader implements ApplicationRunner {

    private Map<String, Usuario> mapa = new HashMap<String, Usuario>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //leitura do arquivo texto

        FileReader file = new FileReader("files/usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            //preenchimento do objeto
            Usuario usuario = new Usuario();
            usuario.setNome(campos[0]);
            usuario.setCpf(campos[1]);
            usuario.setEmail(campos[2]);
            usuario.setId(campos[1] + campos[1]);

            //inclusão do objeto no map
            mapa.put(usuario.getId(), usuario);

            linha = leitura.readLine();
        }

        for (Usuario usuario : mapa.values()) {
            System.out.println("USUARIO " + usuario);
        }

        leitura.close();
    }
}
