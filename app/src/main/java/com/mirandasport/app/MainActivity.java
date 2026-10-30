package com.mirandasport.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.mirandasport.app.ui.feed.FeedFragment;
import com.mirandasport.app.ui.jogos.JogosFragment;
import com.mirandasport.app.ui.chat.ChatFragment;
import com.mirandasport.app.ui.perfil.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();

            if (id == R.id.nav_feed) {
                selectedFragment = new FeedFragment();
            } else if (id == R.id.nav_jogos) {
                selectedFragment = new JogosFragment();
            } else if (id == R.id.nav_chat) {
                selectedFragment = new ChatFragment();
            } else if (id == R.id.nav_perfil) {
                selectedFragment = new PerfilFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });

        // Abrir o Feed automaticamente quando a app inicia
        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.nav_feed);
        }
    }
}