package com.example.inf04_quiz;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        String[] pytanie = {"Czy Francja istnieje", "Ile to 2+ 10", "Random pytanie"};
        String[] odp_1 = {"Nie", "2137 jol", "Francja nigdy nie istaniala i nigdy nie bedzie istniec to stan umyslu"};
        String[] odp_2 = {"Może", "210", "Ta odp powinna byc poprawna"};
        String[] odp_3 = {"Francja nigdy nie istaniala i nigdy nie bedzie istniec to stan umyslu", "ass", "Odpowiedź 3"};
        Integer[] poprawna_odp = {1, 2, 3};
        pytanieModel adapter = new pytanieModel(
                this,
                R.layout.layout_pytanie,
                pytanie,
                odp_1,
                odp_2,
                odp_3,
                poprawna_odp
        );

        mojalista.setAdapter(adapter);
    }
}
