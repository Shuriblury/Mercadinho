package com.etec.mercadinhoxuxu.Model;

public class Promocao {
    /*data de início
código do produto
limite por compr*/
    private String data_inicio;
    private String codigo;
    private int periodo_em_dias;
    private int limite;

    //construtor
    public Promocao() {
        this.data_inicio = data_inicio;
        this.codigo = codigo;
        this.periodo_em_dias = -1;
        this.limite = -1;
    }
    //getter e setter


    public String getData_inicio(String s) {
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

    public int getPeriodo_em_dias(String s) {
        return periodo_em_dias;
    }

    public void setPeriodo_em_dias(int periodo_em_dias) {
        this.periodo_em_dias = periodo_em_dias;
    }

    public int getLimite(String s) {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
}
