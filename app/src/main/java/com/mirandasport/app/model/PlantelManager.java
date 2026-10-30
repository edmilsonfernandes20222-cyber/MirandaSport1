
package com.mirandasport.app.model;

import java.util.ArrayList;
import java.util.List;

public class PlantelManager {

    private static final List<Jogador> plantel = new ArrayList<>();

    public static List<Jogador> getPlantel() {
        return plantel;
    }

    public static void adicionarJogador(Jogador jogador) {
        if (jogador != null) {
            plantel.add(jogador);
        }
    }

    public static void limparPlantel() {
        plantel.clear();
    }
}