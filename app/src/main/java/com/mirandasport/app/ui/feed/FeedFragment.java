package com.mirandasport.app.ui.feed;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.mirandasport.app.R;

public class FeedFragment extends Fragment {

    private EditText searchInput;
    private Button btnSmartBot, btnNewPost, btnLike, btnComment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla o layout visual do feed com a barra de pesquisa e botões
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        // Referências dos elementos visuais do ecrã
        searchInput = view.findViewById(R.id.search_input);
        btnSmartBot = view.findViewById(R.id.btn_smart_bot);
        btnNewPost = view.findViewById(R.id.btn_new_post);
        btnLike = view.findViewById(R.id.btn_like);
        btnComment = view.findViewById(R.id.btn_comment);

        // 1. Ação do Bot Inteligente (Pesquisa na Web e Organização)
        btnSmartBot.setOnClickListener(v -> {
            String query = searchInput.getText().toString().trim();
            if (query.isEmpty()) {
                Toast.makeText(getContext(), "🤖 Bot: Escreve o que pretendes pesquisar na web!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "🤖 A pesquisar na internet e a organizar...", Toast.LENGTH_SHORT).show();

                // Chama o repositório web que criámos para ir buscar dados à internet
                WebRepository.searchWeb(query, result -> {
                    Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
                });
            }
        });

        // 2. Ação do Botão "Criar Publicação / Reel" (Com os Quadros Estilo Rede Social)
        btnNewPost.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_new_post, null);
            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            EditText inputContent = dialogView.findViewById(R.id.input_post_content);
            View frameBackground = dialogView.findViewById(R.id.frame_post_background);
            Button btnToggleBg = dialogView.findViewById(R.id.btn_toggle_backgrounds);
            ImageView btnClose = dialogView.findViewById(R.id.btn_close_dialog);
            Button btnSubmit = dialogView.findViewById(R.id.btn_submit_post);

            // Cores e estilos de "Quadros" para enfeitar as letras conforme o desejo do utilizador
            final int[] backgroundStyles = {
                    android.graphics.Color.parseColor("#2C2C2C"), // Padrão escuro
                    android.graphics.Color.parseColor("#D4AF37"), // Dourado MirandaSport
                    android.graphics.Color.parseColor("#0056B3"), // Azul elegante
                    android.graphics.Color.parseColor("#B22222")  // Vermelho vibrante
            };
            final int[] textColors = {
                    android.graphics.Color.parseColor("#FFFFFF"),
                    android.graphics.Color.parseColor("#121212"),
                    android.graphics.Color.parseColor("#FFFFFF"),
                    android.graphics.Color.parseColor("#FFFFFF")
            };

            final int[] currentIndex = {0};

            // Alternar entre os quadros decorativos ao clicar no botão "Aa"
            btnToggleBg.setOnClickListener(viewBtn -> {
                currentIndex[0] = (currentIndex[0] + 1) % backgroundStyles.length;
                frameBackground.setBackgroundColor(backgroundStyles[currentIndex[0]]);
                inputContent.setTextColor(textColors[currentIndex[0]]);
                inputContent.setHintTextColor(textColors[currentIndex[0]] == android.graphics.Color.WHITE ?
                        android.graphics.Color.parseColor("#CCCCCC") : android.graphics.Color.parseColor("#555555"));
            });

            btnClose.setOnClickListener(viewBtn -> dialog.dismiss());

            // Ação final de publicar o post enfeitado
            btnSubmit.setOnClickListener(viewBtn -> {
                String content = inputContent.getText().toString().trim();
                if (content.isEmpty()) {
                    Toast.makeText(getContext(), "Escreve alguma coisa para publicar!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Publicação efetuada com sucesso no MirandaSport! 🚀", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            });

            dialog.show();
        });

        // 3. Ações de Interação (Reagir e Comentar)
        btnLike.setOnClickListener(v ->
                Toast.makeText(getContext(), "Reagiste com sucesso! ❤️", Toast.LENGTH_SHORT).show()
        );

        btnComment.setOnClickListener(v ->
                Toast.makeText(getContext(), "Abrir caixa de comentários 💬", Toast.LENGTH_SHORT).show()
        );

        return view;
    }
}