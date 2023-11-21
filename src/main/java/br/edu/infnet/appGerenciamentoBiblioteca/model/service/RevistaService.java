package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Revista;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RevistaService {
    private Map<String, Revista> mapa = new HashMap<String, Revista>();

    public void incluir(Revista revista){
        mapa.put(revista.getId(), revista);
    }
    public Collection<Revista> obterLista(){
        return mapa.values();
    }
}
