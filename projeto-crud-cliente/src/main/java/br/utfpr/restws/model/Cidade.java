package br.utfpr.restws.model;

import br.alerario.ICidade;
import java.io.Serializable;

public class Cidade implements ICidade, Serializable {
    private static final long serialVersionUID = 1L;
    
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
