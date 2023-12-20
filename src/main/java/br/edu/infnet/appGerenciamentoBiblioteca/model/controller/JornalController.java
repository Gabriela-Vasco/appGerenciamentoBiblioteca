package br.edu.infnet.appGerenciamentoBiblioteca.model.controller;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Jornal;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.JornalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/jornal")
public class JornalController {
    @Autowired
    JornalService jornalService;

    @GetMapping(value = "/listar")
    public Collection<Jornal> obterTodos(){
        return jornalService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Jornal jornal){
        jornalService.incluir(jornal);
    }
}
