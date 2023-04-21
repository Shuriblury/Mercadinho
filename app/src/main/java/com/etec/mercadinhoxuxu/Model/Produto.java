package com.etec.mercadinhoxuxu.Model;

import java.io.Serializable;

public class Produto implements Serializable {
    /*código
    nome
    descrição
    categoria: bebida, bebida alcoólica, grão, laticínios, fruta, leguminosa... etc*/
    // 1º passo -> criar variaveis
    private int id;
    private String codigo;
    private String nome;
    private String descricao;
    private String categoria;

    public Produto() {
    }

    //2º criar construtores

    public Produto(int id, String codigo, String nome, String descricao, String categoria) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;

    }


    //3º getter e setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Produto{" +
                ", codigo='" + codigo + '\'' +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
