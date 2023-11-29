package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Item;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Livro;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Revista;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.ItemRepository;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void incluir(Item item){
        itemRepository.save(item);
    }
    public Collection<Item> obterLista(){
        return (Collection<Item>) itemRepository.findAll();
    }
}
