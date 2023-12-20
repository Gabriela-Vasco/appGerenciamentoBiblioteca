package br.edu.infnet.appGerenciamentoBiblioteca.model.controller;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Emprestimo;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {
    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping(value = "/listar")
    public Collection<Emprestimo> obterTodos(){
        return emprestimoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Emprestimo emprestimo){
        emprestimoService.incluir(emprestimo);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id){
        emprestimoService.excluir(id);
    }
}
