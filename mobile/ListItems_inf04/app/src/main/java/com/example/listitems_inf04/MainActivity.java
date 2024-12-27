package com.example.listitems_inf04;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

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
        ListView mojalista = findViewById(R.id.lista);
        ArrayList<String> items_list;
        String[] items = {"Zakupy: mleko, masło", "Ugotować obiad", "Sobota: kino"};
        items_list = new ArrayList<>(Arrays.asList(items));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items_list);
        mojalista.setAdapter(adapter);
        Button przycisk_dodaj = findViewById(R.id.button_dodaj);
        przycisk_dodaj.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView mojtekst = findViewById(R.id.text_wpisz);
                items_list.add(mojtekst.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}