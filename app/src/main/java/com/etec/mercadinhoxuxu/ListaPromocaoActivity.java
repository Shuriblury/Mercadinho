package com.etec.mercadinhoxuxu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.etec.mercadinhoxuxu.Controller.PromocaoController;
import com.etec.mercadinhoxuxu.DAO.PromocaoDAO;
import com.etec.mercadinhoxuxu.Model.Promocao;

import java.io.Serializable;

public class ListaPromocaoActivity extends AppCompatActivity {
    private ListView listPromocao;
    private PromocaoController promocaoController = new PromocaoController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_promocao2);

        listPromocao = findViewById(R.id.listFornecedor);

        PromocaoDAO promocaoDAO = new PromocaoDAO(this);

        promocaoController.setPromocaoDAO(promocaoDAO);

        ArrayAdapter<Promocao> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, promocaoController.getListaPromocaoFiltro(false));
        listPromocao.setAdapter(adapter);

        registerForContextMenu(listPromocao);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menuBuscar).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String s) {return false;}

            @Override
            public boolean onQueryTextChange(String s) {

                promocaoController.procuraPromocaoFiltro(s);
                listPromocao.invalidate();
                return false;
            }
        });
        return true;
    }

    public void menuAdicionar (MenuItem menuItem){
        Intent intent = new Intent(ListaPromocaoActivity.this, CadastrarPromocaoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {

        super.onResume();
        promocaoController.getListaPromocaoFiltro(true).clear();
        promocaoController.getListaPromocaoFiltro(true);
        listPromocao.invalidateViews();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto, menu);
    }

    public void excluir (MenuItem menuItem){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        final Promocao promocaoParaApagar = promocaoController.getListaPromocaoFiltro(false).get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Atenção").setMessage("Deseja realmente excluir?")
                .setNegativeButton("Não", null).setPositiveButton("Sim", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

               promocaoController.removerPromocaoDasListas(promocaoParaApagar);
               promocaoController.excluirPromocao(promocaoParaApagar);
               listPromocao.invalidateViews();

            }
        })
                .create();
        dialog.show();
    }

    public void alterar (MenuItem menuItem){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo)
                        menuItem.getMenuInfo();
        final Promocao promocaoParaAtualizar = promocaoController.getListaPromocaoFiltro(false).get(menuInfo.position);
        promocaoController
                .getListaPromocaoFiltro(false)
                .get(menuInfo.position);
        Intent intent = new Intent(ListaPromocaoActivity.this, CadastrarPromocaoActivity.class);
        intent.putExtra("promocao", promocaoParaAtualizar);
        startActivity(intent);
    }







}
