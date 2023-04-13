package com.etec.mercadinhoxuxu.Controller;

/*Classe responsavel por controlar as ações do Model e do DAO*/

import android.view.View;

import com.etec.mercadinhoxuxu.DAO.PromocaoDAO;
import com.etec.mercadinhoxuxu.Model.Promocao;
import com.google.android.material.snackbar.Snackbar;

public class PromocaoController {
// variavel link para o DAO responsavel pelo modelo
    private PromocaoDAO promocaoDAO;

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
            long promocaoInId = promocaoDAO.inserirNaTabela(promocao);
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
}
