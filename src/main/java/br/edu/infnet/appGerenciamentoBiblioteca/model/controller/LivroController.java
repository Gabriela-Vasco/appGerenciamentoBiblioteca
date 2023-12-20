package br.edu.infnet.appGerenciamentoBiblioteca.model.controller;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Livro;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping(value = "/listar")
    public Collection<Livro> obterTodos(){
        return livroService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Livro livro){
        livroService.incluir(livro);
    }
}
