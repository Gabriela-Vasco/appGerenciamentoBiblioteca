package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Jornal;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class JornalService {
    private Map<String, Jornal> mapa = new HashMap<String, Jornal>();

    public void incluir(Jornal jornal){
        mapa.put(jornal.getId(), jornal);
    }
    public Collection<Jornal> obterLista(){
        return mapa.values();
    }
}
