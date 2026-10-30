package com.mirandasport.app.ui.perfil;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PerfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Layout principal do Perfil
        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 60, 40, 40);
        layout.setBackgroundColor(Color.parseColor("#121212")); // Fundo escuro MirandaSport

        // Título do Ecrã
        TextView titleTextView = new TextView(getContext());
        titleTextView.setText("Perfil do Utilizador");
        titleTextView.setTextSize(24);
        titleTextView.setTypeface(null, Typeface.BOLD);
        titleTextView.setTextColor(Color.parseColor("#D4AF37")); // Dourado MirandaSport
        titleTextView.setPadding(0, 0, 0, 30);
        layout.addView(titleTextView);

        // Informação do Utilizador
        TextView infoTextView = new TextView(getContext());
        infoTextView.setText("Bem-vindo ao teu espaço pessoal no MirandaSport. Gere as tuas publicações, treinos e favoritos.");
        infoTextView.setTextSize(14);
        infoTextView.setTextColor(Color.parseColor("#CCCCCC"));
        infoTextView.setPadding(0, 0, 0, 40);
        layout.addView(infoTextView);

        // Botão para Visitar o Site Oficial
        Button btnSite = new Button(getContext());
        btnSite.setText("🌐 Visitar o Nosso Site Oficial");
        btnSite.setBackgroundColor(Color.parseColor("#D4AF37")); // Dourado
        btnSite.setTextColor(Color.parseColor("#121212"));
        btnSite.setTypeface(null, Typeface.BOLD);

        // Ação ao clicar no botão do site (abre o navegador do telemóvel)
        btnSite.setOnClickListener(v -> {
            // Substitui "https://teusite.com" pelo link real do teu site
            String url = "https://www.pensador.com/colecao/edmilsonfernandes20222_1112237/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
        layout.addView(btnSite);

        // Assinatura Oficial do Criador (Admilson Fernandes o Visionário Escritor Eterno)
        TextView creatorTextView = new TextView(getContext());
        creatorTextView.setText("⚡ Criado e Desenvolvido por:\nAdmilson Fernandes o Visionário Escritor Eterno");
        creatorTextView.setTextSize(15);
        creatorTextView.setTypeface(null, Typeface.BOLD);
        creatorTextView.setTextColor(Color.parseColor("#D4AF37"));
        creatorTextView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 60, 0, 0);
        creatorTextView.setLayoutParams(params);
        creatorTextView.setPadding(30, 30, 30, 30);

        layout.addView(creatorTextView);

        return layout;
    }
}