package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.etec.mercadinhoxuxu.Model.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class  FornecedorDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public FornecedorDAO() {
    }

    //função construtor da classe para carregar a
    //conexão
    public FornecedorDAO(Context context){
        this.conexao = new Conexao(context);
        this.banco = conexao.getWritableDatabase();
    }

    public long inserirFornecedor(Fornecedor fornecedor){
        ContentValues valores = new ContentValues();
        valores.put("cnpj", fornecedor.getCnpj());
        valores.put("nome_fantasia", fornecedor.getNome_fantasia());
        valores.put("razao_social", fornecedor.getRazao_social());
        valores.put("telefone1", fornecedor.getTelefone_1());
        valores.put("telefone2", fornecedor.getTelefone_2());
        valores.put("endereco", fornecedor.getEndereco());

        return banco.insert("fornecedor", null, valores);
    }

    //função listar / capturar dados da tabela
    public List<Fornecedor> listaFornecedoresCadastrados(){
        //para guardar os encontrados
        List<Fornecedor> fornecedoresEncontrados = new ArrayList<>();

        //trabalhando com select no SQLite
        //Cursor é = a um ponteiro que "aponta" para a tabela
        //que eu desejo consultar
        Cursor cursor = banco.query("fornecedor",
                new String[]{"cnpj", "nome_fantasia", "razao_social", "telefone1", "telefone2", "endereco"},
                null, null, null,
                null,null, null);

        //cursor guarda todos os resultados então devemos nos guiar
        //por ele para saber onde começam e terminam os dados(row/linhas)
        while(cursor.moveToNext()){
            Fornecedor fornecedorAtual = new Fornecedor();

            fornecedorAtual.setCnpj(cursor.getString(0));
            fornecedorAtual.setNome_fantasia(cursor.getString(1));
            fornecedorAtual.setRazao_social(cursor.getString(2));
            fornecedorAtual.setTelefone_1(cursor.getString(3));
            fornecedorAtual.setTelefone_2(cursor.getString(4));
            fornecedorAtual.setEndereco(cursor.getString(5));

            fornecedoresEncontrados.add(fornecedorAtual);
        }
        return fornecedoresEncontrados;
    }

    //função responsavel por agapgar item do BD
    public void  excluirFornecedor(Fornecedor fornecedor){
        banco.delete("fornecedor", "cnpj = ?"
                ,new String[]{String.valueOf(fornecedor.getCnpj())});
    }
    public void alterarFornecedor(Fornecedor fornecedor, String cnpj) {
        ContentValues values = new ContentValues();
        values.put("cnpj", fornecedor.getCnpj());
        values.put("nome_fantasia", fornecedor.getNome_fantasia());
        values.put("razao_social", fornecedor.getRazao_social());
        values.put("telefone1", fornecedor.getTelefone_1());
        values.put("telefone2", fornecedor.getTelefone_2());
        values.put("endereco", fornecedor.getEndereco());
        banco.update("fornecedor", values, "cnpj=?",
                new String[]{String.valueOf(cnpj)});
    }

}










