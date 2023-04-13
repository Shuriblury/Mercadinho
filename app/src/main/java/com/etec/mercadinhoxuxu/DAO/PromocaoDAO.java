package com.etec.mercadinhoxuxu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;

import com.etec.mercadinhoxuxu.Model.Promocao;

import java.util.ArrayList;
import java.util.List;

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
    public long inserirPromocao(Promocao promocao){
        //insert into nome_tabela(colunas) values(valores)
        ContentValues valores = new ContentValues();
        valores.put("codigo_produto", promocao.getCodigo());
        valores.put("periodo_dias", promocao.getPeriodo_em_dias());
        valores.put("data_inicio", promocao.getData_inicio());
        valores.put("limite_compra", promocao.getLimite());

        return banco.insert("promocao",null, valores);
    }

    public List<Promocao> listaPromocaoCadastrada(){
        List<Promocao> promocaoEncontrada = new ArrayList<>();

        Cursor cursor = banco.query("promocoes", new String[]{"id", "codigo_produto",
                "periodo_dias", "data_inicio", "limite_compra"}, null, null, null, null, null, null);

        while (cursor.moveToNext()){
            Promocao promocaoAtual = new Promocao();

            promocaoAtual.setId(cursor.getInt(0));
            promocaoAtual.setCodigo(cursor.getString(1));
            promocaoAtual.setPeriodo_em_dias(cursor.getInt(3));
            promocaoAtual.setData_inicio(cursor.getString(4));
            promocaoAtual.setLimite(cursor.getInt(5));

            promocaoEncontrada.add(promocaoAtual);
        }
        return promocaoEncontrada;
    }

    public void escluirPromocao(Promocao promocao){
        banco.delete("promocao", "id = ?", new String[]{String.valueOf(promocao.getId())});
    }

}
