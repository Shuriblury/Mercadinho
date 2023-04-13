package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;

import com.etec.mercadinhoxuxu.Model.Promocao;

public class PromocaoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PromocaoDAO(Parcel parcel){

    }

    public PromocaoDAO(Context  context){
        //inicio a conexão
        this.conexao = new Conexao(context);
        //liberar banco de dados para escrita
        this.banco = conexao.getWritableDatabase();
    }

    //função que insere valores na tebela do banco
    public long inserirNaTabela(Promocao promocao){
        //insert into nome_tabela(colunas) values(valores)
        ContentValues valores = new ContentValues();
        valores.put("codigo_produto", promocao.getCodigo());
        valores.put("periodo_dias", promocao.getPeriodo_em_dias());
        valores.put("data_inicio", promocao.getData_inicio());
        valores.put("limite_compra", promocao.getLimite());

        return banco.insert("promocao",null, valores);
    }
}
