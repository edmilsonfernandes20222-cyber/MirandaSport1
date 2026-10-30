package com.mirandasport.app.ui.jogos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mirandasport.app.R;

public class GestaoEquipaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_gestao_equipa,
                container,
                false
        );

        Button btnAdicionar =
                view.findViewById(R.id.btnAdicionarJogador);

        Button btnPlantel =
                view.findViewById(R.id.btnVerPlantel);

        Button btnFormacao =
                view.findViewById(R.id.btnFormacao);

        Button btnVoltar =
                view.findViewById(R.id.btnVoltar);

        btnAdicionar.setOnClickListener(v -> abrirFragment(
                new AdicionarJogadorFragment()
        ));

        btnPlantel.setOnClickListener(v -> abrirFragment(
                new VerPlantelFragment()
        ));

        btnFormacao.setOnClickListener(v ->
                Toast.makeText(
                        requireContext(),
                        "Definir Formação (em breve)",
                        Toast.LENGTH_SHORT
                ).show()
        );

        btnVoltar.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack()
        );

        return view;
    }

    private void abrirFragment(Fragment fragment) {
        FragmentTransaction transaction =
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

        transaction.replace(
                R.id.fragment_container,
                fragment
        );

        transaction.addToBackStack(null);
        transaction.commit();
    }
}
