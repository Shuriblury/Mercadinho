package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;



import com.etec.mercadinhoxuxu.Controller.FornecedorController;
import com.etec.mercadinhoxuxu.DAO.FornecedorDAO;
import com.etec.mercadinhoxuxu.Model.Fornecedor;

public class ListaFornecedorActivity extends AppCompatActivity {

    private ListView listFornecedor;
    private FornecedorController fornecedorController = new FornecedorController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_fornecedor);

        // apontando variavel local para o componente da tela
        listFornecedor = findViewById(R.id.listFornecedor);

        //iniciando a conexão do banco na tela que está aberta
        FornecedorDAO fornecedorDAO = new FornecedorDAO(this);

        //passando a conexão para o controller poder controlar
        fornecedorController.setFornecedorDAO(fornecedorDAO);

        //ensinando a lista da tela como deve ser mostrado cada item
        ArrayAdapter<Fornecedor> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fornecedorController.getListaFornecedoresFiltro(false));
        listFornecedor.setAdapter(adapter);

        //contexto da lista de itens
        registerForContextMenu(listFornecedor);

    }

    //fazendo o menu ser mostrado onde eu quero
    //sobrescrever o método

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);

        //manipular o botão buscar
        SearchView searchView = (SearchView) menu.findItem(R.id.menuBuscar).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                fornecedorController.procuraFornecedorFiltro(s);
                listFornecedor.invalidateViews();
                return false;
            }
        });
        return  true;
    }


    //para tela de cadastro
   public  void menuAdicionar (MenuItem menuItem){
    Intent intent = new Intent(ListaFornecedorActivity.this, CadastroFornecedorActivity.class);
       startActivity(intent);
    }

    //para verificar o estado de ativo novamente da tela
    //Resume
    @Override
    protected void onResume(){
        super.onResume();
        fornecedorController.getListaFornecedoresFiltro(true).clear();
        fornecedorController.getListaFornecedoresFiltro(true);
        listFornecedor.invalidateViews();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto, menu);
    }

    //para ensinar o botão excluir do menu de contexto
    public void excluir (MenuItem menuItem){
        //pegar a posição clicada
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo)
                        menuItem.getMenuInfo();
        final Fornecedor fornecedorParaApagar =
                fornecedorController
                        .getListaFornecedoresFiltro(false)
                        .get(menuInfo.position);
        //dialogo com confirmação
        AlertDialog dialog = new AlertDialog
                .Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja realmente excluir?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //removendo fornecedor
                        //remover a fornecedor da lista
                        fornecedorController.removerFornecedorDasListas(fornecedorParaApagar);
                        fornecedorController.excluirFornecedor(fornecedorParaApagar);
                        listFornecedor.invalidateViews();
                    }
                })
                .create();
        dialog.show();
    }


    public void alterar (MenuItem menuItem){

        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo)
                        menuItem.getMenuInfo();
        final Fornecedor fornecedorParaAtualizar = fornecedorController.getListaFornecedoresFiltro(false).get(menuInfo.position);
                fornecedorController
                        .getListaFornecedoresFiltro(false)
                        .get(menuInfo.position);
        Intent intent =  new Intent(ListaFornecedorActivity.this, CadastroFornecedorActivity.class);
        intent.putExtra("fornecedor", fornecedorParaAtualizar);
        startActivity(intent);

    }

}