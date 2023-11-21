package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Livro;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroService {
    private Map<String, Livro> mapa = new HashMap<String, Livro>();

    public void incluir(Livro livro){
        mapa.put(livro.getId(), livro);
    }
    public Collection<Livro> obterLista(){
        return mapa.values();
    }
}
