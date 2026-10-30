
package com.mirandasport.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout ecra = new FrameLayout(this);

        ImageView fundo = new ImageView(this);
        fundo.setImageResource(R.drawable.mirandasport_logo);
        fundo.setScaleType(ImageView.ScaleType.FIT_CENTER);

        ecra.setBackgroundColor(Color.BLACK);

        ecra.addView(fundo, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        ));

        Button entrar = new Button(this);
        entrar.setText("ENTRAR");
        entrar.setTextColor(Color.BLACK);
        entrar.setTextSize(18);
        entrar.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(
                        Color.rgb(245, 185, 45)
                )
        );

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        Gravity.BOTTOM
                );

        params.setMargins(40, 0, 40, 60);
        ecra.addView(entrar, params);

        entrar.setOnClickListener(v -> {
            startActivity(new Intent(
                    SplashActivity.this,
                    MainActivity.class
            ));
            finish();
        });

        setContentView(ecra);
    }
}
