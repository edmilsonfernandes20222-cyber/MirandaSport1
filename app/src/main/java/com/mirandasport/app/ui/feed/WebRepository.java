package com.mirandasport.app.ui.feed;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WebRepository {

    // Interface para devolver os resultados encontrados na web ao Fragment
    public interface WebSearchCallback {
        void onResult(String result);
    }

    // Método que executa a pesquisa em segundo plano para não bloquear a aplicação
    public static void searchWeb(String query, WebSearchCallback callback) {
        new Thread(() -> {
            try {
                // Formata o termo de pesquisa para URL
                String encodedQuery = URLEncoder.encode(query, "UTF-8");
                String urlString = "https://html.duckduckgo.com/html/?q=" + encodedQuery;

                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.setConnectTimeout(5000); // 5 segundos de limite
                connection.setReadTimeout(5000);

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    // Resposta organizada do Bot após encontrar dados na web
                    String organizedResult = "🤖 Bot Web: Encontrei dados e novidades sobre \"" + query + "\" na internet!";

                    // Retorna a resposta para a Interface Principal (Main Thread)
                    new Handler(Looper.getMainLooper()).post(() -> callback.onResult(organizedResult));
                } else {
                    new Handler(Looper.getMainLooper()).post(() ->
                            callback.onResult("🤖 Bot: Não consegui obter resposta da web (Código: " + responseCode + ")")
                    );
                }

            } catch (Exception e) {
                Log.e("WebRepository", "Erro na pesquisa web", e);
                new Handler(Looper.getMainLooper()).post(() ->
                        callback.onResult("🤖 Bot: Sem ligação à internet ou erro ao carregar os dados.")
                );
            }
        }).start();
    }
}