package com.etec.mercadinhoxuxu.Controller;

import android.view.View;
import android.widget.Toast;

import com.etec.mercadinhoxuxu.DAO.ProdutoDAO;
import com.etec.mercadinhoxuxu.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO;
    private List<Produto> listaProduto;
    private List<Produto> listaProdutodFiltro;

    public ProdutoDAO getProdutoDAO(){return produtoDAO;}

    public void setProdutoDAO(ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    public void salvarProduto(View view, Produto produto){
        this.produtoDAO.inserirProduto(produto);
        Toast.makeText(view.getContext(), "Produto cadastrado", Toast.LENGTH_SHORT).show();
    }

    public List<Produto> getListaProduto() {

        if(this.listaProduto == null ){
            this.listaProduto = new ArrayList<>();
        }
        if(this.listaProduto.isEmpty()){
            this.listaProduto = produtoDAO.listaProdutoCadastrado();
        }

        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public List<Produto> getListaProdutodFiltro() {

        if(this.listaProdutodFiltro == null ){
            this.listaProdutodFiltro = this.getListaProduto();
        }
        if(this.listaProdutodFiltro.isEmpty()){
            this.listaProdutodFiltro.addAll(this.produtoDAO.listaProdutoCadastrado());
        }

        return listaProdutodFiltro;
    }

    public void setListaProdutodFiltro(List<Produto> listaProdutodFiltro) {
        this.listaProdutodFiltro = listaProdutodFiltro;
    }
}
