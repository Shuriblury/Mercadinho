package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    private Button promocaoCadastrada;
    private PromocaoController promocaoController = new PromocaoController();

    private Promocao promocaoIntent = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_promocao);

        PromocaoDAO promocaoDAO = new PromocaoDAO(this);
        promocaoController.setPromocaoDAO(promocaoDAO);


        Promocao promocao = new Promocao();

        periodo_dias = findViewById(R.id.edtPeriodoEmDias);
        data_inicio = findViewById(R.id.edtDataInicio);
        codigo_produto = findViewById(R.id.edtCodigoProdutoPromocao);
        limite_compra = findViewById(R.id.edtLimiteCompra);
        cadastrar = (Button) findViewById(R.id.btnCadastrarTelaPromocao);
        promocaoCadastrada = (Button) findViewById(R.id.btnPromocaoCadastradaTelaPromocao);


        Intent intent = getIntent();
        if (intent.hasExtra("promocao")) {
            this.promocaoIntent = (Promocao) intent.getSerializableExtra("promocao");

            codigo_produto.setText(this.promocaoIntent.getCodigo());
            periodo_dias.setText(this.promocaoIntent.getPeriodo_em_dias());
            data_inicio.setText(this.promocaoIntent.getData_inicio());
            limite_compra.setText(this.promocaoIntent.getLimite());
        }

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promocao.setCodigo(codigo_produto.getText().toString());
                promocao.setPeriodo_em_dias((periodo_dias.getText().toString()));
                promocao.setData_inicio(data_inicio.getText().toString());
                promocao.setLimite((limite_compra.getText().toString()));

                if (promocaoIntent == null) {
                    promocaoController.addPromocao(promocao, view);
                } else {
                    promocaoController.atualizarPromocao(promocao);
                }

            }


        });

        promocaoCadastrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //programando a intenção do botão, o que acontece quando eu aperto cima dele
                Intent intent = new Intent(CadastrarPromocaoActivity.this, ListaPromocaoActivity.class);
                //criada a intenção precisamos iniciar ela
                startActivity(intent);
            }
        });



    }

}
