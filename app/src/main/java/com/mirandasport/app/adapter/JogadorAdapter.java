package com.mirandasport.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirandasport.app.R;
import com.mirandasport.app.model.Jogador;

import java.util.List;

public class JogadorAdapter extends RecyclerView.Adapter<JogadorAdapter.JogadorViewHolder> {

    private final List<Jogador> lista;

    public JogadorAdapter(List<Jogador> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public JogadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jogador, parent, false);
        return new JogadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JogadorViewHolder holder, int position) {
        Jogador jogador = lista.get(position);
        holder.tvNome.setText(jogador.getNome());
        holder.tvInfo.setText(jogador.getPosicao() + "  •  Nº " + jogador.getNumero() + "  •  " + jogador.getIdade() + " anos  •  Pé " + jogador.getPePreferido());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class JogadorViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvInfo;

        public JogadorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvInfo = itemView.findViewById(R.id.tvInfo);
        }
    }
}
