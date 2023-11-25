package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Jornal;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.JornalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JornalService {
    @Autowired
    private JornalRepository jornalRepository;

    public void incluir(Jornal jornal){
        jornalRepository.save(jornal);
    }
    public Collection<Jornal> obterLista(){
        return (Collection<Jornal>) jornalRepository.findAll();
    }
}
