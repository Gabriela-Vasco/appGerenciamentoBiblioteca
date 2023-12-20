package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Emprestimo;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public void incluir(Emprestimo emprestimo){
        emprestimoRepository.save(emprestimo);
    }
    public Collection<Emprestimo> obterLista(){
        return (Collection<Emprestimo>) emprestimoRepository.findAll();
    }

    public void excluir(Integer id) {
        emprestimoRepository.deleteById(id);
    }
}
