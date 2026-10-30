package com.mirandasport.app.ui.jogos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mirandasport.app.R;
import com.mirandasport.app.model.Jogador;
import com.mirandasport.app.model.PlantelManager;

public class AdicionarJogadorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_adicionar_jogador, container, false);

        // Ligar os campos
        EditText etNome = view.findViewById(R.id.etNome);
        Spinner spinnerPosicao = view.findViewById(R.id.spinnerPosicao);
        EditText etNumero = view.findViewById(R.id.etNumero);
        EditText etIdade = view.findViewById(R.id.etIdade);
        Spinner spinnerPe = view.findViewById(R.id.spinnerPe);
        Button btnGuardar = view.findViewById(R.id.btnGuardar);
        Button btnCancelar = view.findViewById(R.id.btnCancelar);

        // Preencher o Spinner de Posições
        String[] posicoes = {
                "Guarda-Redes", "Defesa Central", "Lateral Direito", "Lateral Esquerdo",
                "Médio Defensivo", "Médio Centro", "Médio Ofensivo",
                "Extremo Direito", "Extremo Esquerdo", "Avançado"
        };
        ArrayAdapter<String> adapterPosicao = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_dropdown_item, posicoes);
        spinnerPosicao.setAdapter(adapterPosicao);

        // Preencher o Spinner de Pé Preferido
        String[] pes = {"Direito", "Esquerdo", "Ambos"};
        ArrayAdapter<String> adapterPe = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_dropdown_item, pes);
        spinnerPe.setAdapter(adapterPe);

        // Botão Guardar
        btnGuardar.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();
            String posicao = spinnerPosicao.getSelectedItem().toString();
            String numeroStr = etNumero.getText().toString().trim();
            String idadeStr = etIdade.getText().toString().trim();
            String pe = spinnerPe.getSelectedItem().toString();

            if (nome.isEmpty() || numeroStr.isEmpty() || idadeStr.isEmpty()) {
                Toast.makeText(getContext(), "Preenche todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int numero = Integer.parseInt(numeroStr);
                int idade = Integer.parseInt(idadeStr);

                Jogador novoJogador = new Jogador(nome, posicao, numero, idade, pe);
                PlantelManager.adicionarJogador(novoJogador);

                Toast.makeText(getContext(), "Jogador " + nome + " adicionado com sucesso!", Toast.LENGTH_LONG).show();
                requireActivity().getSupportFragmentManager().popBackStack();

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Número e Idade têm de ser válidos!", Toast.LENGTH_SHORT).show();
            }
        });

        // Botão Cancelar
        btnCancelar.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack());

        return view;
    }
}
