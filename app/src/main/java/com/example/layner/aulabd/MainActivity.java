package com.example.layner.aulabd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContatinhoDAO contatinhoDAO = new ContatinhoDAO(MainActivity.this);
        //contatinhoDAO.retrieveAllContatinhos();
        Contatinho contatinho = new Contatinho(1,"Layner","123","teste");
        contatinhoDAO.insertContatinho(contatinho);
    }
}
