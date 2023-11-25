package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Revista;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RevistaService {
    @Autowired
    private RevistaRepository revistaRepository;

    public void incluir(Revista revista){
        revistaRepository.save(revista);
    }
    public Collection<Revista> obterLista(){
        return (Collection<Revista>) revistaRepository.findAll();
    }
}
