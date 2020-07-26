package br.utfpr.restws.model;

import br.alerario.ICidade;
import br.alerario.ICliente;

public class Cliente implements ICliente {
    private int codigo;
    private String nome;
    private ICidade cidade;

    @Override
    public int getCodigo() {
        return this.getCodigo();
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
