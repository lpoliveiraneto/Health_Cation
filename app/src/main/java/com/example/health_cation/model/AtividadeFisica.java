package com.example.health_cation.model;

public class AtividadeFisica {

    private int idAtividade;
    private String atividadeFisica;
    private String descAtividade;

    public AtividadeFisica(String atividadeFisica, String descAtividade){
        this.atividadeFisica = atividadeFisica;
        this.descAtividade = descAtividade;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public String getDescAtividade() {
        return descAtividade;
    }

    public void setDescAtividade(String descAtividade) {
        this.descAtividade = descAtividade;
    }
}
