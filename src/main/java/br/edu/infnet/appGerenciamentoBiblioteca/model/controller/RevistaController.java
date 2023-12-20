package br.edu.infnet.appGerenciamentoBiblioteca.model.controller;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Jornal;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Revista;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/revista")
public class RevistaController {
    @Autowired
    RevistaService revistaService;

    @GetMapping(value = "/listar")
    public Collection<Revista> obterTodos(){
        return revistaService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Revista revista){
        revistaService.incluir(revista);
    }
}
