package br.edu.infnet.appGerenciamentoBiblioteca.model.repositories;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Emprestimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends CrudRepository<Emprestimo, Integer> {
}
