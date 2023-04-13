package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //dentro do onCreate vamos instaciar os objetos
    // que precisamos utilizar
    //só funciona dentro deste método, pois é onde tudo na tela
    //é criado...antes do "onCreate" não existe nada criado...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //botões que serão acionados para movimentar entre telas

//[1] [2] = ([3]) [4]
//1 - Tipo do botão: uma classe com letra maiuscula
//2 - Nome: um nome qualquer que será utilizado nomente dentro da classe atual
//3 - Casting:  Mesmo tipo escolhido no item 1
//4 -id: identificador do botão igual ao utilizado na tela
//2 e 4 não precisam ser igual um ao outro!

        Button btnTelaCadastroProduto = (Button) findViewById(R.id.btnTelaCadastroProduto);

        Button btnTelaCadastroFornecedor = (Button) findViewById(R.id.btnTelaCadastroFornecedor);

        Button btnTelaCadastroPromocao = (Button) findViewById(R.id.btnTelaCadastroPromocao);


        //programando a ação de clique de cada botão acima instanciado

        //nomedobotão.setOnclick....

        btnTelaCadastroProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //programando a intenção do botão, o que acontece quando eu aperto cima dele
                Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
                //criada a intenção precisamos iniciar ela
                startActivity(intent);
            }
        });

        btnTelaCadastroPromocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //programando a intenção do botão, o que acontece quando eu aperto cima dele
                Intent intent = new Intent(MainActivity.this, CadastrarPromocaoActivity.class);
                //criada a intenção precisamos iniciar ela
                startActivity(intent);
            }
        });

        btnTelaCadastroFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //programando a intenção do botão, o que acontece quando eu aperto cima dele
                Intent intent = new Intent(MainActivity.this, CadastroFornecedorActivity.class);
                //criada a intenção precisamos iniciar ela
                startActivity(intent);
            }
        });

    }
}