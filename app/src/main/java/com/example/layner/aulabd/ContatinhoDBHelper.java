package com.example.layner.aulabd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Layner on 10/10/2018.
 */

public class ContatinhoDBHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE = "CREATE TABLE " + ContatinhoContract.NOME_TABELA + " ( " +
            ContatinhoContract.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ContatinhoContract.COLUNA_NOME + " TEXT, " +
            ContatinhoContract.COLUNA_TELEFONE + " TEXT, " +
            ContatinhoContract.COLUNA_INFO + " TEXT); ";

    private static final String SQL_DELETE = "DROP TABLE IF EXISTS " + ContatinhoContract.NOME_TABELA;
    private static final int VERSAO = 1;
    private static final String NOME_DATABASE = "Agendacontatinhos.db";

    public ContatinhoDBHelper(Context context){
        super(context, NOME_DATABASE, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE);
        onCreate(sqLiteDatabase);
    }
}
