package com.example.health_cation.model;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private float altura;
    private float peso;
    private String parente;
    private String contato_parente;

    public User(String nome, String email, String senha, float altura, float peso, String parente,
                String contato_parente){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.altura = altura;
        this.peso = peso;
        this.parente = parente;
        this.contato_parente = contato_parente;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getParente() {
        return parente;
    }

    public void setParente(String parente) {
        this.parente = parente;
    }

    public String getContato_parente() {
        return contato_parente;
    }

    public void setContato_parente(String contato_parente) {
        this.contato_parente = contato_parente;
    }
}
