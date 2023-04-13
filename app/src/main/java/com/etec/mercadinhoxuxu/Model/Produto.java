package com.etec.mercadinhoxuxu.Model;

public class Produto {
    /*código
    nome
    descrição
    categoria: bebida, bebida alcoólica, grão, laticínios, fruta, leguminosa... etc*/
    // 1º passo -> criar variaveis
    private String codigo;
    private String nome;
    private String descricao;
    private String categoria;

    //2º criar construtores
    public Produto(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    //3º getter e setter
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
