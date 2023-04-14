package com.etec.mercadinhoxuxu.Controller;

/*Classe responsavel por controlar as ações do Model e do DAO*/

import android.view.View;
import android.widget.Toast;

import com.etec.mercadinhoxuxu.DAO.FornecedorDAO;
import com.etec.mercadinhoxuxu.DAO.PromocaoDAO;
import com.etec.mercadinhoxuxu.Model.Fornecedor;
import com.etec.mercadinhoxuxu.Model.Promocao;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class PromocaoController {

private PromocaoDAO promocaoDAO;
private List<Promocao> listaPromocao;
private List<Promocao> listaPromocaoFiltro;

  public PromocaoDAO getPromocaoDAO(){
      return promocaoDAO;
  }

    public void setPromocaoDAO(PromocaoDAO promocaoDAO) {
        this.promocaoDAO = promocaoDAO;
    }

    //função responsavel por receber as informações
    //da view e enviar ao DAO
    public void salvarFornecedor(View view, Promocao promocao){
        this.promocaoDAO.inserirPromocao(promocao);
        Toast.makeText(view.getContext(),
                "Promocao cadastrado",
                Toast.LENGTH_SHORT).show();
    }

    public List<Promocao> getListaPromocao() {
        if(this.listaPromocao == null ){
            this.listaPromocao = new ArrayList<>();
        }
        if(this.listaPromocao.isEmpty()){
            this.listaPromocao = promocaoDAO.listaPromocaoCadastrada();
        }
        return listaPromocao;
    }

    public void setListaPromocao(List<Promocao> listaPromocao) {
        this.listaPromocao = listaPromocao;
    }

    public List<Promocao> getListaPromocaoFiltro() {
        if(this.listaPromocaoFiltro == null ){
            this.listaPromocaoFiltro = this.getListaPromocao();
        }
        if(this.listaPromocaoFiltro.isEmpty()){
            this.listaPromocaoFiltro.addAll(this.promocaoDAO.listaPromocaoCadastrada());
        }
        return listaPromocaoFiltro;
    }

    public void setListaPromocaoFiltro(List<Promocao> listaPromocaoFiltro) {
        this.listaPromocaoFiltro = listaPromocaoFiltro;
    }


    public void addPromocao(Promocao promocao, View view) {
    }
}
