package br.edu.infnet.appGerenciamentoBiblioteca.model.controller;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Item;
import br.edu.infnet.appGerenciamentoBiblioteca.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/listar")
    public Collection<Item> obterTodos(){
        return itemService.obterLista();
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id){
        itemService.excluir(id);
    }
}
