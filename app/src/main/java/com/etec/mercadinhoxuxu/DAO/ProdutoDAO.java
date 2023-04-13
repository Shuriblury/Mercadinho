package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.etec.mercadinhoxuxu.Model.Produto;

public class ProdutoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context){
        this.conexao = new Conexao(context);
        this.banco = conexao.getWritableDatabase();
    }

    public long inserir(Produto produto){
        ContentValues valores = new ContentValues();
        valores.put("codigo", produto.getCodigo());
        valores.put("nome", produto.getNome());
        valores.put("descricao",produto.getDescricao());
        valores.put("categoria",produto.getCategoria());

        return banco.insert("produto", null, valores);
    }

}
