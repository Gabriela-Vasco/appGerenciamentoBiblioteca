package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Livro;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public void incluir(Livro livro){
        livroRepository.save(livro);
    }
    public Collection<Livro> obterLista(){
        return (Collection<Livro>) livroRepository.findAll();
    }
}
