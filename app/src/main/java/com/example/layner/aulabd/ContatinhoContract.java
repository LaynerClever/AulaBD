package com.example.layner.aulabd;

import android.provider.BaseColumns;

/**
 * Created by Layner on 10/10/2018.
 */

public final class ContatinhoContract implements BaseColumns {
    private ContatinhoContract(){}

    public static final String NOME_TABELA = "contatinhos";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_INFO = "info";
}
