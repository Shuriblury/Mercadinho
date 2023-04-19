package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.etec.mercadinhoxuxu.Controller.ProdutoController;
import com.etec.mercadinhoxuxu.DAO.ProdutoDAO;
import com.etec.mercadinhoxuxu.Model.Produto;

public class CadastroProdutoActivity extends AppCompatActivity {


    //tudo o que eu tenho na tela
    private EditText nome;
    private EditText descricao;
    private EditText categoria;
    private Button cadastrar;
    private ProdutoController produtoController= new ProdutoController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        ProdutoController.setProdutoDAO(produtoDAO);


        Produto produto = new Produto();

        nome = findViewById(R.id.edtNomeProduto);
        categoria = findViewById(R.id.edtCategoriaProduto);
        descricao = findViewById(R.id.edtDescricaoProduto);


        cadastrar = findViewById(R.id.btnCadastrarProduto);


        //adapter pega uma lista/conjunto de dados do mesmo tipo
        //e organiza de acordo com algum modelo

        //lista de times: São Paulo, Vasco, Corinthians, Palmeiras

        //ArrayAdapter<String> adapterTimes =  new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,fornecedor.getListaTimes());
        //time.setAdapter(adapterTimes);


        //ensinando ao botão salvar o que ele deve fazer
        //quando acionado
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produto.setNome(nome.getText().toString());
                produto.setCategoria(categoria.getText().toString());
                produto.setDescricao(descricao.getText().toString());



                ProdutoController.salvarProduto(view, produto);

            }
        });

        Button btnProdutosCadastrados = (Button) findViewById(R.id.btnCadastrarProduto);
        btnProdutosCadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //programando a intenção do botão, o que acontece quando eu aperto cima dele
                Intent intent = new Intent(CadastroProdutoActivity.this, ListaProdutoActivity.class);
                //criada a intenção precisamos iniciar ela
                startActivity(intent);
            }
        });



    }
}