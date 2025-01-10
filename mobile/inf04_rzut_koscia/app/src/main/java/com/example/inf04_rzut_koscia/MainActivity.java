package com.example.inf04_rzut_koscia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    int suma_wszystkich_oczek = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView kostka1 = findViewById(R.id.kostka1);
        ImageView kostka2 = findViewById(R.id.kostka2);
        ImageView kostka3 = findViewById(R.id.kostka3);
        ImageView kostka4 = findViewById(R.id.kostka4);
        ImageView kostka5 = findViewById(R.id.kostka5);
        ImageView[] mojezdjecia = {kostka1, kostka2, kostka3, kostka4, kostka5};
        int[] oczka = {R.drawable.question, R.drawable.oczko1, R.drawable.oczko2, R.drawable.oczko3, R.drawable.oczko4, R.drawable.oczko5, R.drawable.oczko6};
        Button zagraj = findViewById(R.id.button_rzut);
        Button resetuj = findViewById(R.id.button_resetuj);
        TextView wynik_jednej_gry = findViewById(R.id.wynik_tego_los);
        TextView wynik_calej_gry = findViewById(R.id.wynik_gry);
        zagraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int suma_oczek = 0;
                int zakres = 6;
                Integer[] tablica_oczek = new Integer[5];
                for (int counter = 0; counter < 5; counter++) {
                    tablica_oczek[counter] = (int)(Math.random() * zakres + 1);
                    mojezdjecia[counter].setImageResource(oczka[tablica_oczek[counter]]);
                }

                for (int i = 0; i < 5; i++) {
                    if(Collections.frequency(Arrays.asList(tablica_oczek), tablica_oczek[i]) > 1)
                    {
                        suma_oczek = suma_oczek + tablica_oczek[i];
                    }
                }

                suma_wszystkich_oczek = suma_wszystkich_oczek + suma_oczek;
                wynik_jednej_gry.setText("Wynik tego losowania: "+suma_oczek);
                wynik_calej_gry.setText("Wynik całej gry: "+suma_wszystkich_oczek);
            }
        });
        resetuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int counter = 0; counter < 5; counter++){
                    mojezdjecia[counter].setImageResource(oczka[0]);
                    suma_wszystkich_oczek = 0;
                    wynik_jednej_gry.setText("Wynik tego losowania: 0");
                    wynik_calej_gry.setText("Wynik całej gry: "+suma_wszystkich_oczek);
                }
            }
        });
    }
}