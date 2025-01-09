package com.example.cwiczenie_czcionka_09012025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public int counter = 0;
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
        Button strzalki = findViewById(R.id.tekst_idz_dalej);
        Button resetuj = findViewById(R.id.tekst_resetuj);
        TextView tekst_koncowy = findViewById(R.id.tekst_wynik);
        EditText mojrozmiar = findViewById(R.id.tekst_cyfra);
        ProgressBar mojekolo = findViewById(R.id.tekst_kolko);
        SeekBar mojzamek = findViewById(R.id.tekst_pasek);
        mojzamek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int wartosc = mojzamek.getProgress();
                mojrozmiar.setText(String.valueOf(wartosc));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        resetuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strzalki.setEnabled(true);
                mojzamek.setProgress(10);
                counter = 0;
                mojekolo.setProgress(0);
                tekst_koncowy.setTextSize(10);
            }
        });
        mojrozmiar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    try {
                        int sizerek = Integer.parseInt(mojrozmiar.getText().toString());
                        if(sizerek > 9 && sizerek < 51){
                            mojzamek.setProgress(sizerek);
                        }
                    }
                    catch (Exception e){

                    }
                }
            }
        });
        strzalki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int sizerek = Integer.parseInt(mojrozmiar.getText().toString());
                    if(sizerek > 9 && sizerek < 51){
                        mojzamek.setProgress(sizerek);
                        counter = counter + 1;
                        mojekolo.setProgress(counter);
                        if(mojekolo.getProgress() == mojekolo.getMax()){
                            strzalki.setEnabled(false);
                        }
                        tekst_koncowy.setTextSize(sizerek);
                    }
                }
                catch (Exception e){

                }

            }
        });
    }
}