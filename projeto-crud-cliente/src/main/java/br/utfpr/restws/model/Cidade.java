package br.utfpr.restws.model;

import br.alerario.ICidade;

public class Cidade implements ICidade {
    private int codigo;
    private String nome;

    public Cidade() {
    }

    public Cidade(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
