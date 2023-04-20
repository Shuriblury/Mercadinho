package com.etec.mercadinhoxuxu.Model;

public class Promocao {
    /*data de início
código do produto
limite por compr*/
    private int id;
    private String data_inicio;
    private String codigo;
    private int periodo_em_dias;
    private int limite;

    //construtor

    public Promocao() {
        this.id = id;
        this.data_inicio = data_inicio;
        this.codigo = codigo;
        this.periodo_em_dias = -1;
        this.limite = -1;
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

    public int getPeriodo_em_dias() {
        return periodo_em_dias;
    }

    public void setPeriodo_em_dias(int periodo_em_dias) {
        this.periodo_em_dias = periodo_em_dias;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @NonNull
    @Override
    public String toString() {
        return "Promocao{" + "data_inicio='" + data_inicio + '\'' +
                ", codigo='" + codigo + '\'' +
                ", periodo_em_dias='" + periodo_em_dias + '\'' +
                ", limite='" + limite + '\'' +
                '}';
    }
}
