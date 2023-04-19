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
    private List<Produto> listaProdutosFiltro;

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    //função responsavel por receber as informações
    //da view e enviar ao DAO
    public void salvarProduto(View view, Produto produto){
        this.produtoDAO.inserir(produto);
        Toast.makeText(view.getContext(),
                "Produto cadastrado",
                Toast.LENGTH_SHORT).show();
    }

    public List<Produto> getListaProdutos() {
        if(this.listaProdutos == null ){
            this.listaProdutos = new ArrayList<>();
        }
        if(this.listaProdutos.isEmpty()){
            this.listaProdutos = produtoDAO.listaProdutosCadastrados();
        }
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<Produto> getListaProdutosFiltro(boolean voltou) {
        if(this.getListaProdutos() == null ){
            this.getListaProdutosFiltro() = this.getListaProdutos();
        }
        if(voltou ){
            this.listaProdutos.addAll(this.produtoDAO.listaProdutosCadastrados());
        }
        return listaProdutos;
    }

    public void setListaProdutoesFiltro(List<Produto> listaProdutosCadastrados) {
        this.listaProdutos = listaProdutosCadastrados;
    }

    //filtro para busca na lista
    public void procuraProdutosCadastrados(String filtro){
        this.getListaProdutosFiltro(true).clear();
        for(Produto produto : this.getListaProdutosFiltro()){
            if(produto.getCodigo().toLowerCase()
                    .contains(filtro.toLowerCase())){
                this.getListaProdutosFiltro(false).add(produto);
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