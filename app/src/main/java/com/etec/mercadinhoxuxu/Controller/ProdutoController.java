package com.etec.mercadinhoxuxu.Controller;
import android.view.View;
import android.widget.Toast;


import com.etec.mercadinhoxuxu.DAO.ProdutoDAO;
import com.etec.mercadinhoxuxu.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    //link para utilizar o que o DAO provê
    private ProdutoDAO produtoDAO;
    private List<Produto> listaProdutos;
    private List<Produto> listaProdutosCadastrados;

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    //função responsavel por receber as informações
    //da view e enviar ao DAO
    public void salvarProduto(View view, Produto produto){
        this.produtoDAO.inserirProduto(produto);
        Toast.makeText(view.getContext(),
                "Produto cadastrado",
                Toast.LENGTH_SHORT).show();
    }

    public List<Produto> getListaProdutoes() {
        if(this.listaProdutos == null ){
            this.listaProdutos = new ArrayList<>();
        }
        if(this.listaProdutos.isEmpty()){
            this.listaProdutos = produtoDAO.listaProdutosCadastrados();
        }
        return listaProdutos;
    }

    public void setListaProdutoes(List<Produto> listaProdutoes) {
        this.listaProdutos = listaProdutoes;
    }

    public List<Produto> getListaProdutoesFiltro(boolean voltou) {
        if(this.getListaProdutoes() == null ){
            this.getListaProdutoes() = this.getListaProdutoes();
        }
        if(voltou ){
            this.listaProdutos.addAll(this.produtoDAO.listaProdutoesCadastrados());
        }
        return listaProdutos;
    }

    public void setListaProdutoesFiltro(List<Produto> listaProdutoesFiltro) {
        this.listaProdutos = listaProdutoesFiltro;
    }

    //filtro para busca na lista
    public void procuraProdutoFiltro(String filtro){
        this.getListaProdutoesFiltro(true).clear();
        for(Produto produto : this.getListaProdutoesFiltro()){
            if(produto.getCodigo().toLowerCase()
                    .contains(filtro.toLowerCase())){
                this.getListaProdutoesFiltro(false).add(produto);
            }
        }

    }

    //função excluir
    public void excluirProduto(Produto produto){
        this.produtoDAO.excluirProduto(produto);
    }

    public void removerProdutoDasListas(Produto produtoParaApagar) {
        this.listaProdutos.remove(produtoParaApagar);
        this.listaProdutos.remove(produtoParaApagar);
    }
}