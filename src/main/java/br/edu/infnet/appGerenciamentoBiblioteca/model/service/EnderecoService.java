package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.controller.clients.IEnderecoClient;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private IEnderecoClient enderecoClient;
    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);
    }

}
