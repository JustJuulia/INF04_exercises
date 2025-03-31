package com.example.inf04_stoper;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // UI elements
    private EditText editTextHours, editTextMinutes, editTextSeconds;
    private TextView textViewTimer;
    private Button buttonStart, buttonStop, buttonReset;

    // Timer variables
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    private long timeLeftInMillis = 0;
    private long lastSetTimeInMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextHours = findViewById(R.id.editTextHours);
        editTextMinutes = findViewById(R.id.editTextMinutes);
        editTextSeconds = findViewById(R.id.editTextSeconds);
        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonReset = findViewById(R.id.buttonReset);

        // Set button click listeners
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    return;
                }

                if (timeLeftInMillis <= 0) {
                    // Get time from input fields
                    try {
                        int hours = editTextHours.getText().toString().isEmpty() ? 0 :
                                Integer.parseInt(editTextHours.getText().toString());
                        int minutes = editTextMinutes.getText().toString().isEmpty() ? 0 :
                                Integer.parseInt(editTextMinutes.getText().toString());
                        int seconds = editTextSeconds.getText().toString().isEmpty() ? 0 :
                                Integer.parseInt(editTextSeconds.getText().toString());

                        // Convert to milliseconds
                        timeLeftInMillis = (hours * 3600000) + (minutes * 60000) + (seconds * 1000);
                        lastSetTimeInMillis = timeLeftInMillis;

                        if (timeLeftInMillis <= 0) {
                            Toast.makeText(MainActivity.this, "Please enter a valid time", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                startTimer();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    pauseTimer();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateTimerText();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                timeLeftInMillis = 0;
                updateTimerText();
                Toast.makeText(MainActivity.this, "Timer finished!", Toast.LENGTH_SHORT).show();
            }
        }.start();

        timerRunning = true;
        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        timerRunning = false;
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
    }

    private void resetTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        timerRunning = false;
        timeLeftInMillis = lastSetTimeInMillis;
        updateTimerText();
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
    }

    private void updateTimerText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        int milliseconds = (int) (timeLeftInMillis % 1000);

        String timeLeftFormatted = String.format(Locale.getDefault(),
                "%02d:%02d:%02d.%03d",
                hours, minutes, seconds, milliseconds);
        textViewTimer.setText(timeLeftFormatted);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}