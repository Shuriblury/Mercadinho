package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.etec.mercadinhoxuxu.Model.Produto;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ProdutoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context){
        this.conexao = new Conexao(context);
        this.banco = conexao.getWritableDatabase();
    }

    public long inserirProduto(Produto produto){
        ContentValues valores = new ContentValues();
        valores.put("codigo", produto.getCodigo());
        valores.put("nome", produto.getNome());
        valores.put("descricao",produto.getDescricao());
        valores.put("categoria",produto.getCategoria());

        return banco.insert("produto", null, valores);
    }
public List<Produto> listaProdutoCadastrado(){
        List<Produto> produtosEncontrado = new ArrayList<>();

    Cursor cursor = banco.query("produto", new String[]{"id", "codigo", "nome", "descricao",
            "categoria"}, null, null, null,
            null, null, null);

    while (cursor.moveToNext()){
        Produto produtoAtual = new Produto();
        produtoAtual.setId(cursor.getInt(0));
        produtoAtual.setCodigo(cursor.getString(1));
        produtoAtual.setNome(cursor.getString(2));
        produtoAtual.setDescricao(cursor.getString(3));
        produtoAtual.setCategoria(cursor.getString(4));

        produtosEncontrado.add(produtoAtual);
    }

    return produtosEncontrado;

    }

        public void exlucirProduto(Produto produto){
        banco.delete("fornecedor", "id = ?",
                new String[]{String.valueOf(produto.getId())});
        }

}
