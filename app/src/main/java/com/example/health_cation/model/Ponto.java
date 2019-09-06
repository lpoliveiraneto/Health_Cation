package com.example.health_cation.model;

public class Ponto {

    private int idPontos;
    private String ponto;
    private int valorDoPonto = 0;
    private String descAtividade;
    private User user;

    public Ponto(String ponto){
        this.ponto = ponto;
    }

    public int getIdPontos() {
        return idPontos;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public int getValorDoPonto() {
        return valorDoPonto;
    }

    public String getDescAtividade() {
        return descAtividade;
    }

    public User getUser() {
        return user;
    }
}
