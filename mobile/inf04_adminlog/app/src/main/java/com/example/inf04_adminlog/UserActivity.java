package com.example.inf04_adminlog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_hi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String login = getIntent().getStringExtra("LOGIN");
        TextView user_hi_tekst = findViewById(R.id.user_hello);
        AllUsers userDatabase = AllUsers.getInstance();
        User loggedInUser = null;

        for (User user : userDatabase.getAllUsers()) {
            if (user.getLogin().equals(login)) {
                loggedInUser = user;
                break;
            }
        }
        user_hi_tekst.setText("Siemano! imie: "+loggedInUser.name+" nazwisko: "+loggedInUser.surname+" sori mordeczko n masz admina");

    }
}