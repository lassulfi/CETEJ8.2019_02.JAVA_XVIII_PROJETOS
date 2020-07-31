package br.utfpr.restws.model;

import br.alerario.ICidade;
import br.alerario.ICliente;
import java.io.Serializable;

public class Cliente implements ICliente, Serializable {
    private static final long serialVersionUID = 1L;
    
    private int codigo;
    private String nome;
    private ICidade cidade;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, ICidade cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
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

    @Override
    public ICidade getCidade() {
        return this.cidade;
    }

    @Override
    public void setCidade(ICidade cidade) {
        this.cidade = cidade;
    }
}
