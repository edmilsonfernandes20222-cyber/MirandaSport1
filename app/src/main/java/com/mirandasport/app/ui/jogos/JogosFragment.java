package com.mirandasport.app.ui.jogos;

import com.mirandasport.app.R;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class JogosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 60, 40, 40);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        // Título
        TextView titulo = new TextView(getContext());
        titulo.setText("Secção de Jogos");
        titulo.setTextSize(24);
        titulo.setPadding(0, 0, 0, 40);
        layout.addView(titulo);

        // Botão 1 - Gestão de Equipa
        Button btnGestaoEquipa = new Button(getContext());
        btnGestaoEquipa.setText("Gestão de Equipa");
        btnGestaoEquipa.setOnClickListener(v -> {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new GestaoEquipaFragment());
            transaction.addToBackStack(null); // permite voltar
            transaction.commit();
        });
        layout.addView(btnGestaoEquipa);

        // Botão 2 - Planos Táticos
        Button btnPlanos = new Button(getContext());
        btnPlanos.setText("Planos Táticos");
        btnPlanos.setOnClickListener(v ->
                Toast.makeText(getContext(), "Planos Táticos (em breve)", Toast.LENGTH_SHORT).show());
        layout.addView(btnPlanos);

        // Botão 3 - Criar Jogo
        Button btnCriarJogo = new Button(getContext());
        btnCriarJogo.setText("Criar Jogo");
        btnCriarJogo.setOnClickListener(v ->
                Toast.makeText(getContext(), "Criar Jogo (em breve)", Toast.LENGTH_SHORT).show());
        layout.addView(btnCriarJogo);

        // Botão 4 - Competições
        Button btnCompeticoes = new Button(getContext());
        btnCompeticoes.setText("Competições (Liga / Taça / Torneio)");
        btnCompeticoes.setOnClickListener(v ->
                Toast.makeText(getContext(), "Competições (em breve)", Toast.LENGTH_SHORT).show());
        layout.addView(btnCompeticoes);

        return layout;
    }
}