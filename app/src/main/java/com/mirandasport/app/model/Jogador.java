package com.mirandasport.app.model;

public class Jogador {

    private String nome;
    private String posicao;
    private int numero;
    private int idade;
    private String pePreferido; // Direito, Esquerdo ou Ambos

    public Jogador(String nome, String posicao, int numero, int idade, String pePreferido) {
        this.nome = nome;
        this.posicao = posicao;
        this.numero = numero;
        this.idade = idade;
        this.pePreferido = pePreferido;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getNumero() {
        return numero;
    }

    public int getIdade() {
        return idade;
    }

    public String getPePreferido() {
        return pePreferido;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPePreferido(String pePreferido) {
        this.pePreferido = pePreferido;
    }
}