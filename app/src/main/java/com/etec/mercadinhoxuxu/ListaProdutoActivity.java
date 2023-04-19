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
import com.etec.mercadinhoxuxu.Controller.ProdutoController;
import com.etec.mercadinhoxuxu.DAO.FornecedorDAO;
import com.etec.mercadinhoxuxu.DAO.ProdutoDAO;
import com.etec.mercadinhoxuxu.Model.Fornecedor;
import com.etec.mercadinhoxuxu.Model.Produto;

public class ListaProdutoActivity extends AppCompatActivity {

    private ListView listProduto;
    private ProdutoController produtoController = new ProdutoController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);
    }



    // apontando variavel local para o componente da tela
    listProduto = findViewById(R.id.listProduto);

    //iniciando a conexão do banco na tela que está aberta
    ProdutoDAO produtoDAO = new ProdutoDAO(this);

    //passando a conexão para o controller poder controlar
        ProdutoController.setProdutoDAO(ProdutoDAO);

    //ensinando a lista da tela como deve ser mostrado cada item
    ArrayAdapter<Produto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produtoController.getListaProdutosCadastrados(false));
        listProduto.setAdapter(adapter);

    //contexto da lista de itens
    registerForContextMenu(listProduto);

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
                ProdutoController.procuraProdutoFiltro(s);
                listProduto.invalidateViews();
                return false;
            }
        });
        return  true;
    }


    //para tela de cadastro
    public  void menuAdicionar (MenuItem menuItem){
        Intent intent = new Intent(ListaProdutoActivity.this, CadastroProdutoActivity.class);
        startActivity(intent);
    }

    //para verificar o estado de ativo novamente da tela
    //Resume
    @Override
    protected void onResume(){
        super.onResume();
        ProdutoController.getListaProdutoCadastrado(true).clear();
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
        final Produto produtoParaApagar =
                produtoController
                        .getListaProdutosCadastrados(false)
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
                        produtoController.removerProdutoDasListas(produtoParaApagar);
                        produtoController.excluirProduto(produtoParaApagar);
                        listProduto.invalidateViews();
                    }
                })
                .create();
        dialog.show();









    }
}