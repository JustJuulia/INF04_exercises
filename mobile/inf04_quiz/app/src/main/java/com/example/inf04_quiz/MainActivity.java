package com.example.inf04_quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int aktualnyWynik = 0;
    private TextView wynikTextView;
    private FrameLayout podsumowanieContainer;
    private View podsumowanieView;
    private pytanieModel adapter;



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

        ListView mojalista = findViewById(R.id.pytanie_listview);
        List<String[]> listaPytan = generujPytania();


        LayoutInflater inflater = getLayoutInflater();
        View footerView = inflater.inflate(R.layout.layout_podsumowanie, mojalista, false);
        mojalista.addFooterView(footerView);

        wynikTextView = footerView.findViewById(R.id.text_wynik);

        pytanieModel adapter = new pytanieModel(this, R.layout.layout_pytanie, listaPytan, wynikTextView);
        mojalista.setAdapter(adapter);
        Button resetButton = footerView.findViewById(R.id.button_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.resetujOdpowiedzi();
            }
        });
    }
    private List<String[]> generujPytania() {
        List<String[]> pytania = new ArrayList<>();
        String[][] danePytan = {
                {"Jaki język programowania jest używany do tworzenia aplikacji na Androida?", "Java", "Python", "C#", "1"},
                {"Który język jest używany do tworzenia aplikacji webowych?", "HTML", "C#", "Java", "1"},
                {"Jakie jest największe miasto w Polsce?", "Warszawa", "Kraków", "Wrocław", "1"},
                {"Jaka jest stolica Francji?", "Berlin", "Madryt", "Paryż", "3"},
                {"Kto wynalazł telefon?", "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "1"},
                {"Który z tych systemów operacyjnych jest używany na komputerach Apple?", "Windows", "macOS", "Linux", "2"},
                {"Jakie jest najbliższe ciało niebieskie Ziemi?", "Mars", "Słońce", "Księżyc", "3"},
                {"Jaki jest największy ocean na świecie?", "Ocean Atlantycki", "Ocean Spokojny", "Ocean Indyjski", "2"},
                {"Które z tych zwierząt jest ssakiem?", "Krokodyl", "Pies", "Żaba", "2"},
                {"Co to jest HTML?", "Hyper Text Markup Language", "Home Tool Markup Language", "Hyperlink Markup Language", "1"}
        };
        for (int i = 0; i < 10; i++) {
            pytania.add(danePytan[i]);
        }
        return pytania;
    }


}
