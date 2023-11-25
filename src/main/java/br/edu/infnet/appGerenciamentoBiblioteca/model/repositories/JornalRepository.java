package br.edu.infnet.appGerenciamentoBiblioteca.model.repositories;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Jornal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornalRepository extends CrudRepository<Jornal, Integer> {
}
