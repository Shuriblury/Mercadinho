package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.etec.mercadinhoxuxu.Model.Fornecedor;

public class FornecedorDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public FornecedorDAO() {
    }

    public FornecedorDAO(Context context){
        this.conexao = new Conexao(context);
        this.banco = conexao.getWritableDatabase();
    }

    public long inserir(Fornecedor fornecedor){
        ContentValues valores = new ContentValues();
        valores.put("cnpj", fornecedor.getCnpj());
        valores.put("nome_fantasia", fornecedor.getNome_fantasia());
        valores.put("razao_socia", fornecedor.getRazao_social());
        valores.put("telefone1", fornecedor.getTelefone_1());
        valores.put("telefone2", fornecedor.getTelefone_2());
        valores.put("endereco", fornecedor.getEndereco());

        return banco.insert("fornecedor", null, valores);
    }

}










