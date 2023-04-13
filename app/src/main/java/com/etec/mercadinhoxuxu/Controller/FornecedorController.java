package com.etec.mercadinhoxuxu.Controller;
import android.view.View;
import android.widget.Toast;


import com.etec.mercadinhoxuxu.DAO.FornecedorDAO;
import com.etec.mercadinhoxuxu.Model.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class FornecedorController {
    //link para utilizar o que o DAO provê
    private FornecedorDAO fornecedorDAO;
    private List<Fornecedor> listaFornecedors;
    private List<Fornecedor> listaFornecedorsFiltro;

    public FornecedorDAO getFornecedorDAO() {
        return fornecedorDAO;
    }

    public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }

    //função responsavel por receber as informações
    //da view e enviar ao DAO
    public void salvarFornecedor(View view, Fornecedor fornecedor){
        this.fornecedorDAO.inserirFornecedor(fornecedor);
        Toast.makeText(view.getContext(),
                "Fornecedor cadastrado",
                Toast.LENGTH_SHORT).show();
    }

    public List<Fornecedor> getListaFornecedors() {
        if(this.listaFornecedors == null ){
            this.listaFornecedors = new ArrayList<>();
        }
        if(this.listaFornecedors.isEmpty()){
            this.listaFornecedors = fornecedorDAO.listaFornecedoresCadastrados();
        }
        return listaFornecedors;
    }

    public void setListaFornecedors(List<Fornecedor> listaFornecedors) {
        this.listaFornecedors = listaFornecedors;
    }

    public List<Fornecedor> getListaFornecedorsFiltro(boolean voltou) {
        if(this.listaFornecedorsFiltro == null ){
            this.listaFornecedorsFiltro = this.getListaFornecedors();
        }
        if(voltou ){
            this.listaFornecedorsFiltro.addAll(this.fornecedorDAO.listaFornecedoresCadastrados());
        }
        return listaFornecedorsFiltro;
    }

    public void setListaFornecedorsFiltro(List<Fornecedor> listaFornecedorsFiltro) {
        this.listaFornecedorsFiltro = listaFornecedorsFiltro;
    }

    //filtro para busca na lista
    public void procuraFornecedorFiltro(String filtro){
        this.getListaFornecedorsFiltro(true).clear();
        for(Fornecedor fornecedor : this.getListaFornecedors()){
            if(fornecedor.getCnpj().toLowerCase()
                    .contains(filtro.toLowerCase())){
                this.getListaFornecedorsFiltro(false).add(fornecedor);
            }
        }

    }

    //função excluir
    public void excluirFornecedor(Fornecedor fornecedor){
        this.fornecedorDAO.excluirFornecedor(fornecedor);
    }

    public void removerFornecedorDasListas(Fornecedor fornecedorParaApagar) {
        this.listaFornecedors.remove(fornecedorParaApagar);
        this.listaFornecedorsFiltro.remove(fornecedorParaApagar);
    }
}