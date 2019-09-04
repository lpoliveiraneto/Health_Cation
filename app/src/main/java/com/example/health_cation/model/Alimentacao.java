package com.example.health_cation.model;

public class Alimentacao {

    private int idAlimento;
    private String alimento;
    private String descAlimento;
    private float caloria;

    public Alimentacao(String alimento, String descAlimento, float caloria){
        this.alimento = alimento;
        this.descAlimento = descAlimento;
        this.caloria = caloria;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getDescAlimento() {
        return descAlimento;
    }

    public void setDescAlimento(String descAlimento) {
        this.descAlimento = descAlimento;
    }

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(float caloria) {
        this.caloria = caloria;
    }
}
