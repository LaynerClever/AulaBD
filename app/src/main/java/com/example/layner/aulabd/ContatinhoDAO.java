package com.example.layner.aulabd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Layner on 10/10/2018.
 */

public class ContatinhoDAO {
    private ContatinhoDBHelper contatinhoDBHelper;

    public ContatinhoDAO(Context context) {
        this.contatinhoDBHelper = new ContatinhoDBHelper(context);
    }

    public boolean insertContatinho(Contatinho contatinho){
        SQLiteDatabase sqLiteDatabase = contatinhoDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContatinhoContract.COLUNA_NOME, contatinho.getNome());
        contentValues.put(ContatinhoContract.COLUNA_TELEFONE, contatinho.getTelefone());
        contentValues.put(ContatinhoContract.COLUNA_INFO, contatinho.getInfo());

        long affectedRows = sqLiteDatabase.insert(ContatinhoContract.COLUNA_NOME,null, contentValues);
        if (affectedRows == -1) return false;
        return true;
    }

    public boolean deleteContatinho(int id){
        SQLiteDatabase sqLiteDatabase = contatinhoDBHelper.getWritableDatabase();

        String where = ContatinhoContract.COLUNA_ID + " = ?";
        String[] valuesWhere = {String.valueOf(id)};

        long affectedRows  = sqLiteDatabase.delete(ContatinhoContract.NOME_TABELA, where, valuesWhere);
        if (affectedRows == -1) return false;
        return true;
    }

    public boolean editContatinho (Contatinho contatinho){
        SQLiteDatabase sqLiteDatabase = contatinhoDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContatinhoContract.COLUNA_NOME, contatinho.getNome());
        contentValues.put(ContatinhoContract.COLUNA_TELEFONE, contatinho.getTelefone());
        contentValues.put(ContatinhoContract.COLUNA_INFO, contatinho.getInfo());

        String where = ContatinhoContract.COLUNA_ID + " = ?";
        String[] valuesWhere = {String.valueOf(contatinho.getId())};

        long affectedRows  = sqLiteDatabase.delete(ContatinhoContract.NOME_TABELA, where, valuesWhere);
        if (affectedRows == -1) return false;
        return true;
    }

    public ArrayList<Contatinho> retrieveAllContatinhos(){
        SQLiteDatabase sqLiteDatabase = contatinhoDBHelper.getReadableDatabase();

        String[] columns = {ContatinhoContract.COLUNA_ID, ContatinhoContract.COLUNA_NOME,
                ContatinhoContract.COLUNA_TELEFONE, ContatinhoContract.COLUNA_INFO};

        String order = ContatinhoContract.COLUNA_NOME + " ASC";
        Cursor  result = sqLiteDatabase.query(ContatinhoContract.NOME_TABELA,
                columns, null, null, null, null, order);

        ArrayList<Contatinho> contatinhos = new ArrayList<Contatinho>();

        while (result.moveToNext()){
            Contatinho contatinho = new Contatinho();
            contatinho.setId(result.getInt(result.getColumnIndex(ContatinhoContract.COLUNA_ID)));
            contatinho.setNome(result.getString(result.getColumnIndex(ContatinhoContract.COLUNA_NOME)));
            contatinho.setTelefone(result.getString(result.getColumnIndex(ContatinhoContract.COLUNA_TELEFONE)));
            contatinho.setInfo(result.getString(result.getColumnIndex(ContatinhoContract.COLUNA_INFO)));
            contatinhos.add(contatinho);
        }
        result.close();
        sqLiteDatabase.close();
        return contatinhos;
    }
}
