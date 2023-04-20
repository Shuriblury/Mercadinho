package com.etec.mercadinhoxuxu.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//ela precisa extender SQLite(o banco de dados basicos para
//baixo volume de dados.
public class Conexao extends SQLiteOpenHelper {
    //constante que representa o nome da base de dados;
    private static String NOMEDOBANCO = "mercado2.db";
    //constante que representa a versão do banco
    private static int VERSION = 1;

    //construtor da conexão
    public Conexao(Context context){
        super(context, NOMEDOBANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     //criação das tabelas
      //create table nome_tabela(atrib);
     //tabela produto

    //tabela fornecedor
        /*CNPJ
Nome fantasia
Razão Social
Telefone 1
Telefone 2
Endereço*/
    sqLiteDatabase.execSQL("create table fornecedor(" +
            "cnpj Varchar primary key," +
            "nome_fantasia varchar(100)," +
            "razao_social varchar(100)," +
            "telefone1 varchar(20)," +
            "telefone2 varchar(20)," +
            "endereco varchar(200))");
    //tabela promoção
        /*período em dias
data de início
código do produto
limite por compr*/
    sqLiteDatabase.execSQL("create table promocao(" +
            "codigo int primary key,"+
            "codigo_produto varchar(50)," +
            "periodo_dias varchar(10)," +
            "data_inicio varchar(10)," +
            "limite_compra int)");

        sqLiteDatabase.execSQL("create table produto(" +
                "codigo varchar(50) primary key," +
                "nome varchar(20)," +
                "descricao''(20)," +
                "categoria varchar(20))");

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}





