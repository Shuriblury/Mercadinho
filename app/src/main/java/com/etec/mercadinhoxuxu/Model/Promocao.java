package com.etec.mercadinhoxuxu.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Promocao  implements Serializable {
    /*data de início
código do produto
limite por compr*/
    private int id;
    private String data_inicio;
    private String codigo;
    private String periodo_em_dias;
    private String limite;

    //construtor

    public Promocao() {
        this.id = id;
        this.data_inicio = data_inicio;
        this.codigo = codigo;
        this.periodo_em_dias = periodo_em_dias;
        this.limite = limite;
    }
    //getter e setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPeriodo_em_dias() {
        return periodo_em_dias;
    }

    public void setPeriodo_em_dias(String periodo_em_dias) {
        this.periodo_em_dias = periodo_em_dias;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Promocao{" +
                "id=" + id +
                ", data_inicio='" + data_inicio + '\'' +
                ", codigo='" + codigo + '\'' +
                ", periodo_em_dias='" + periodo_em_dias + '\'' +
                ", limite='" + limite + '\'' +
                '}';
    }
}
