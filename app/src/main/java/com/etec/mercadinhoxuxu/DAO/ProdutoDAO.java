package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.etec.mercadinhoxuxu.Model.Fornecedor;
import com.etec.mercadinhoxuxu.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO() {
    }

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

    //função listar / capturar dados da tabela
    public List<Produto> listaProdutosFiltro(){
        //para guardar os encontrados
        List<Produto> produtosEncontrados = new ArrayList<>();

        //trabalhando com select no SQLite
        //Cursor é = a um ponteiro que "aponta" para a tabela
        //que eu desejo consultar
        Cursor cursor = banco.query("produto",
                new String[]{ "codigo","nome", "categoria", "descricao"},
                null, null, null,
                null,null, null);

        //cursor guarda todos os resultados então devemos nos guiar
        //por ele para saber onde começam e terminam os dados(row/linhas)
        while(cursor.moveToNext()){
            Produto produtoAtual = new Produto();

            produtoAtual.setCodigo(cursor.getString(0));
            produtoAtual.setNome(cursor.getString(1));
            produtoAtual.setCategoria(cursor.getString(2));
            produtoAtual.setDescricao(cursor.getString(3));

            produtosEncontrados.add(produtoAtual);
        }
        return produtosEncontrados;
    }

    //função responsavel por agapgar item do BD
    public void  excluirProduto(Produto produto){
        banco.delete("produto", "codigo = ?"
                ,new String[]{String.valueOf(produto.getCodigo())});
    }

    public void alterarProduto(Produto produto, String codigo) {
        ContentValues values = new ContentValues();
        values.put("codigo", produto.getCodigo());
        values.put("nome", produto.getNome());
        values.put("descricao", produto.getDescricao());
        values.put("categoria", produto.getCategoria());
        banco.update("produto", values, "codigo=?",
                new String[]{String.valueOf(codigo)});
    }

}
