package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Emprestimo;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmprestimoService {
    private Map<String, Emprestimo> mapa = new HashMap<String, Emprestimo>();

    public void incluir(Emprestimo emprestimo){
        mapa.put(emprestimo.getId(), emprestimo);
    }
    public Collection<Emprestimo> obterLista(){
        return mapa.values();
    }
}
