package br.edu.infnet.appGerenciamentoBiblioteca.model.repositories;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
