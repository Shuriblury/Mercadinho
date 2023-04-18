package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.etec.mercadinhoxuxu.Controller.PromocaoController;
import com.etec.mercadinhoxuxu.DAO.PromocaoDAO;
import com.etec.mercadinhoxuxu.Model.Promocao;

public class CadastrarPromocaoActivity extends AppCompatActivity {

    private EditText codigo_produto;
    private EditText periodo_dias;
    private EditText data_inicio;
    private EditText limite_compra;
    private Button cadastrar;
    private PromocaoController promocaoController = new PromocaoController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_promocao);

        PromocaoDAO promocaoDAO = new PromocaoDAO(this);
        promocaoController.setPromocaoDAO(promocaoDAO);


        Promocao promocao = new Promocao();

        periodo_dias = findViewById(R.id.edtPeriodoEmdias);
        data_inicio = findViewById(R.id.edtDataInicio);
        codigo_produto = findViewById(R.id.edtCodigoProdutoPromocao);
        limite_compra = findViewById(R.id.edtLimiteCompra);

        cadastrar = findViewById(R.id.btnTelaCadastroPromocao);

        cadastrar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             promocao.setCodigo(codigo_produto.getText().toString());
                                             promocao.getPeriodo_em_dias(periodo_dias.getText().toString());
                                             promocao.getData_inicio(data_inicio.getText().toString());
                                             promocao.getLimite(limite_compra.getText().toString());

                                             promocaoController.salvarPromocao(view, promocao);

                                         }
                                     });

       Button btnPromocaoCadastrado = (Button) findViewById(R.id.btnTelaCadastroPromocao);
       btnPromocaoCadastrado.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {
               Intent intent = new Intent(CadastrarPromocaoActivity.this, Lista)
           }
       });


            @Override
            public void onClick(View view) {
                /*quando o botão for acionado, cria-se o obj, com as
                * informações alimentadas em tela*/
                Promocao promocao = new Promocao
                        (
                        );
                promocao.setLimite
                        (Integer.parseInt(limite_compra.getText().toString()));
                promocao.setPeriodo_em_dias
                        (Integer.parseInt(periodo_dias.getText().toString()));

                promocaoController.addPromocao(promocao, view);

            }
        });











    }
}