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
    private List<Fornecedor> listaFornecedores;
    private List<Fornecedor> listaFornecedoresFiltro;

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

    public List<Fornecedor> getListaFornecedores() {
        if(this.listaFornecedores == null ){
            this.listaFornecedores = new ArrayList<>();
        }
        if(this.listaFornecedores.isEmpty()){
            this.listaFornecedores = fornecedorDAO.listaFornecedoresCadastrados();
        }
        return listaFornecedores;
    }

    public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }

    public List<Fornecedor> getListaFornecedoresFiltro(boolean voltou) {
        if(this.listaFornecedoresFiltro == null ){
            this.listaFornecedoresFiltro = this.getListaFornecedores();
        }
        if(voltou ){
            this.listaFornecedoresFiltro.addAll(this.fornecedorDAO.listaFornecedoresCadastrados());
        }
        return listaFornecedoresFiltro;
    }

    public void setListaFornecedoresFiltro(List<Fornecedor> listaFornecedoresFiltro) {
        this.listaFornecedoresFiltro = listaFornecedoresFiltro;
    }

    //filtro para busca na lista
    public void procuraFornecedorFiltro(String filtro){
        this.getListaFornecedoresFiltro(true).clear();
        for(Fornecedor fornecedor : this.getListaFornecedores()){
            if(fornecedor.getCnpj().toLowerCase()
                    .contains(filtro.toLowerCase())){
                this.getListaFornecedoresFiltro(false).add(fornecedor);
            }
        }

    }

    //função excluir
    public void excluirFornecedor(Fornecedor fornecedor){
        this.fornecedorDAO.excluirFornecedor(fornecedor);
    }

    public void removerFornecedorDasListas(Fornecedor fornecedorParaApagar) {
        this.listaFornecedores.remove(fornecedorParaApagar);
        this.listaFornecedoresFiltro.remove(fornecedorParaApagar);
    }

    public void atualizarFornecedor(Fornecedor fornecedor){
        this.fornecedorDAO.alterarFornecedor(fornecedor, fornecedor.getCnpj());
    }
}