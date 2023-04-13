package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.etec.mercadinhoxuxu.Controller.PromocaoController;
import com.etec.mercadinhoxuxu.DAO.PromocaoDAO;
import com.etec.mercadinhoxuxu.Model.Promocao;

public class CadastrarPromocaoActivity extends AppCompatActivity {

    /*M - Model
    * v - View
    * C - Controller*/
    //precisamos criar os links com MVC
    private PromocaoDAO promocaoDAO;
    private PromocaoController promocaoController;

    //campos utilizados na tela
    private EditText codigo_produto;
    private EditText periodo_dias;
    private EditText data_inicio;
    private EditText limite_compra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_promocao);

        //instacia dos objetos criados anteriormente
        this.promocaoDAO = new PromocaoDAO(this);
        this.promocaoController = new PromocaoController();
        //this.promocaoController.

        //botão que fica na tela de cadastro de promocao
        Button btnCadastrar = (Button) findViewById(R.id.btnTelaCadastroPromocao);

        //alimentando variaveis criadas anteriormente;
        this.codigo_produto = findViewById(R.id.edtCodigoProdutoPromocao);
        this.periodo_dias = findViewById(R.id.edtPeriodoEmdias);
        this.data_inicio = findViewById(R.id.edtDataInicio);
        this.limite_compra = findViewById(R.id.edtLimiteCompra);

        //agora precisamos ensinar o botão ao ser clicado
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
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