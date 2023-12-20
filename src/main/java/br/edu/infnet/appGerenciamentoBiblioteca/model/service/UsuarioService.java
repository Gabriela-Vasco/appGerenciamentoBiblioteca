package br.edu.infnet.appGerenciamentoBiblioteca.model.service;

import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Endereco;
import br.edu.infnet.appGerenciamentoBiblioteca.model.domain.Usuario;
import br.edu.infnet.appGerenciamentoBiblioteca.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    public void incluir(Usuario usuario){
        String cep = usuario.getEndereco().getCep();

        Endereco endereco = enderecoService.buscarCep(cep);

        usuario.setEndereco(endereco);

        usuarioRepository.save(usuario);
    }
    public Collection<Usuario> obterLista(){
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
