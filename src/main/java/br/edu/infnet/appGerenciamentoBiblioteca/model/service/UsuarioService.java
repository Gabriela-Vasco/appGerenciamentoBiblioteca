package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
    private Map<String, Usuario> mapa = new HashMap<String, Usuario>();

    public void incluir(Usuario usuario){
        mapa.put(usuario.getId(), usuario);
    }
    public Collection<Usuario> obterLista(){
        return mapa.values();
    }
}
