
package com.mirandasport.app.ui.jogos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirandasport.app.R;
import com.mirandasport.app.adapter.JogadorAdapter;
import com.mirandasport.app.model.Jogador;
import com.mirandasport.app.model.PlantelManager;

import java.util.List;

public class VerPlantelFragment extends Fragment {

    private TextView tvTotal;
    private TextView tvVazio;
    private RecyclerView recyclerPlantel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_ver_plantel,
                container,
                false
        );

        tvTotal = view.findViewById(R.id.tvTotal);
        tvVazio = view.findViewById(R.id.tvVazio);
        recyclerPlantel = view.findViewById(R.id.recyclerPlantel);

        Button btnVoltar = view.findViewById(R.id.btnVoltar);

        // Organizar os jogadores verticalmente, de cima para baixo.
        recyclerPlantel.setLayoutManager(
                new LinearLayoutManager(requireContext())
        );

        btnVoltar.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack()
        );

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        atualizarPlantel();
    }

    private void atualizarPlantel() {

        List<Jogador> plantel = PlantelManager.getPlantel();

        if (plantel == null || plantel.isEmpty()) {

            tvTotal.setVisibility(View.GONE);
            recyclerPlantel.setVisibility(View.GONE);
            tvVazio.setVisibility(View.VISIBLE);

            tvVazio.setText("Ainda não existem jogadores registados.");

        } else {

            tvVazio.setVisibility(View.GONE);
            tvTotal.setVisibility(View.VISIBLE);
            recyclerPlantel.setVisibility(View.VISIBLE);

            tvTotal.setText(
                    "Total de jogadores: " + plantel.size()
            );

            recyclerPlantel.setAdapter(
                    new JogadorAdapter(plantel)
            );
        }
    }
}
