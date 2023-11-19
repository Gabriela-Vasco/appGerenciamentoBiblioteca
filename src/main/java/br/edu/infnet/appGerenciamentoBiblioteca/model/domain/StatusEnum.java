package br.edu.infnet.appGerenciamentoBiblioteca.model.domain;

public enum StatusEnum {
    ATRASADO("Atrasado"), DEVOLVIDO("Devolvido"), EMDIA("Em dia");

    private final String descricao;

    StatusEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public String toString(){
        return getDescricao();
    }
}
