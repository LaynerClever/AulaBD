package com.example.layner.aulabd;

/**
 * Created by Layner on 10/10/2018.
 */

public class Contatinho {
    private int id;
    private String nome;
    private  String telefone;
    private String info;

    public Contatinho(){}

    public Contatinho(int id, String nome, String telefone, String info){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
