package com.example.inf04_pralka;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int stan_odkurzacz = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView odkurzacz_zasilanie = findViewById(R.id.text_odkurzacz_zasilanie);
        TextView pralka_liczba_tekst = findViewById(R.id.text_pralka_numer_prania);
        EditText pralka_liczba = findViewById(R.id.number_pralka);
        Button pralka_zatwierdz = findViewById(R.id.button_zatwierdz);
        Button odkurzacz_przycisk = findViewById(R.id.button_odkurzacz);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pralka_zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int liczba_prania = Integer.parseInt(pralka_liczba.getText().toString());
                if(0 < liczba_prania && liczba_prania < 13){
                    pralka_liczba_tekst.setText("Numer prania: "+liczba_prania);
                }

            }
        });
        odkurzacz_przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stan_odkurzacz == 0){
                    stan_odkurzacz = 1;
                    odkurzacz_zasilanie.setText("Odkurzacz włączony");
                    odkurzacz_przycisk.setText("Wyłącz");
                }
                else{
                    stan_odkurzacz = 0;
                    odkurzacz_zasilanie.setText("Odkurzacz wyłączony");
                    odkurzacz_przycisk.setText("Włącz");
                }
            }
        });
    }



}