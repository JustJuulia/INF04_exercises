package com.example.inf04_stoper;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private Button buttonStart, buttonStop, buttonReset;

    private Handler handler = new Handler();
    private long startTime = 0;
    private long timeElapsed = 0;
    private boolean timerRunning = false;

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();
            timeElapsed = currentTime - startTime;
            updateTimerText();
            handler.postDelayed(this, 10); // Aktualizacja co 10 ms
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonReset = findViewById(R.id.buttonReset);

        buttonStart.setOnClickListener(v -> startTimer());
        buttonStop.setOnClickListener(v -> pauseTimer());
        buttonReset.setOnClickListener(v -> resetTimer());

        updateTimerText();
    }

    private void startTimer() {
        if (!timerRunning) {
            startTime = System.currentTimeMillis() - timeElapsed; // Kontynuacja od poprzedniego czasu
            handler.post(timerRunnable);
            timerRunning = true;
            buttonStart.setEnabled(false);
            buttonStop.setEnabled(true);
        }
    }

    private void pauseTimer() {
        if (timerRunning) {
            handler.removeCallbacks(timerRunnable);
            timerRunning = false;
            buttonStart.setEnabled(true);
            buttonStop.setEnabled(false);
        }
    }

    private void resetTimer() {
        handler.removeCallbacks(timerRunnable);
        timerRunning = false;
        timeElapsed = 0;
        updateTimerText();
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
    }

    private void updateTimerText() {
        int hours = (int) (timeElapsed / 3600000);
        int minutes = (int) (timeElapsed / 60000) % 60;
        int seconds = (int) (timeElapsed / 1000) % 60;
        int milliseconds = (int) (timeElapsed % 1000);

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
        textViewTimer.setText(timeFormatted);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(timerRunnable);
    }
}
