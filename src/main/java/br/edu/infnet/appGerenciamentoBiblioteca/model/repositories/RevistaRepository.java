package br.edu.infnet.appGerenciamentoBiblioteca.model.repositories;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Revista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaRepository extends CrudRepository<Revista, Integer> {
}
