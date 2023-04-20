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

    public List<Promocao> getListaPromocaoFiltro(boolean voltou) {
        if(this.listaPromocaoFiltro == null ){
            this.listaPromocaoFiltro = this.getListaPromocao();
        }
        if(voltou){
            this.listaPromocaoFiltro.addAll(this.promocaoDAO.listaPromocaoCadastrada());
        }
        return listaPromocaoFiltro;
    }

    public void setListaPromocaoFiltro(List<Promocao> listaPromocaoFiltro) {
        this.listaPromocaoFiltro = listaPromocaoFiltro;
    }

    //função responsavel por receber os dados da tela
    //no formato do model
    //função com o nome addPromocao
    //que recebe 2 parametros para funcionar
    //uma promocao e uma view, ambos objetos...
    public  void  addPromocao(Promocao promocao, View view){
        //sempre que vamos fazer operações perigosas
        //que tendem a parar o programa precisamos
        //fazer com os erros sejam contornados sem prejudicar
        //o uso da aplicação try..catch
        try{
            //a função inserir criada no DAO retorna um long
            //podemos utilizar ele para saber se esta ok
            //com o procedimento
            long promocaoInId = promocaoDAO.inserirPromocao(promocao);
            System.out.println(promocaoInId);

            //mostrar popup de mensagem na tela
            Snackbar.make(view, "Promoção " + promocaoInId +
                    "inserida com sucesso", 1000).show();
        }catch (Exception e){
            e.printStackTrace();
            Snackbar.make(view, "Promoção não inserida" +
                    "", 1000).show();
        }
    }

    public void atualizarPromocao(Promocao promocao){
    this.promocaoDAO.alterarPromocao(promocao, promocao.getCodigo());
    }

    public void procuraPromocaoFiltro(String s) {
      //falta fazer
    }

    public void removerPromocaoDasListas(Promocao promocaoParaApagar) {
    }

    public void excluirPromocao(Promocao promocaoParaApagar) {
    }
}
