package com.mirandasport.app.model;

import java.util.ArrayList;
import java.util.List;

public class Equipa {

    private String nome;
    private String treinadoPor;
    private String formacao; // Ex: 4-3-3, 4-4-2, 3-5-2
    private List<Jogador> jogadores;

    public Equipa(String nome, String treinadoPor, String formacao) {
        this.nome = nome;
        this.treinadoPor = treinadoPor;
        this.formacao = formacao;
        this.jogadores = new ArrayList<>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTreinadoPor() {
        return treinadoPor;
    }

    public String getFormacao() {
        return formacao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTreinadoPor(String treinadoPor) {
        this.treinadoPor = treinadoPor;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    // Métodos úteis
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }

    public int getNumeroJogadores() {
        return jogadores.size();
    }
}