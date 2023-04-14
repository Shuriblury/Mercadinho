package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.etec.mercadinhoxuxu.Controller.FornecedorController;
import com.etec.mercadinhoxuxu.DAO.FornecedorDAO;
import com.etec.mercadinhoxuxu.Model.Fornecedor;

public class CadastroFornecedorActivity extends AppCompatActivity {


        //tudo o que eu tenho na tela
        private EditText cnpj;
        private EditText nomeFantasia;
        private EditText razaoSocial;
        private EditText telefone1;
        private EditText telefone2;
        private EditText endereco;
        private Button cadastrar;
        private FornecedorController fornecedorController = new FornecedorController();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_fornecedor);

            FornecedorDAO fornecedorDAO = new FornecedorDAO(this);
            fornecedorController.setFornecedorDAO(fornecedorDAO);


            Fornecedor fornecedor = new Fornecedor();

            cnpj = findViewById(R.id.edtCnpj);
            nomeFantasia = findViewById(R.id.edtNomeFantasia);
            razaoSocial = findViewById(R.id.edtRazaoSocial);
            telefone1 = findViewById(R.id.edtTelefone1);
            telefone2 = findViewById(R.id.edtTelefone2);
            endereco = findViewById(R.id.edtEndereco);

            cadastrar = findViewById(R.id.btnCadastroFornecedor);


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
                    fornecedor.setCnpj(cnpj.getText().toString());
                    fornecedor.setNome_fantasia(nomeFantasia.getText().toString());
                    fornecedor.setRazao_social(razaoSocial.getText().toString());
                    fornecedor.setTelefone_1(telefone1.getText().toString());
                    fornecedor.setTelefone_2(telefone2.getText().toString());
                    fornecedor.setEndereco(endereco.getText().toString());


                    fornecedorController.salvarFornecedor(view, fornecedor);

                }
            });

            Button btnFornecedoresCadastrados = (Button) findViewById(R.id.btnFornecedoresCadastrados);
            btnFornecedoresCadastrados.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //programando a intenção do botão, o que acontece quando eu aperto cima dele
                    Intent intent = new Intent(CadastroFornecedorActivity.this, ListaFornecedorActivity.class);
                    //criada a intenção precisamos iniciar ela
                    startActivity(intent);
                }
            });



        }
    }