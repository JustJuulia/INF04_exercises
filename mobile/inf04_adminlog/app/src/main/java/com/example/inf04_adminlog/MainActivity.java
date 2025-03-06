package com.example.inf04_adminlog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.inf04_adminlog.User;
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
        AllUsers userDatabase = AllUsers.getInstance();
        User mainAdmin = new User("admin", "admin", "Admin", "User", true);
        boolean adminExists = false;

        for (User user : userDatabase.getAllUsers()) {
            if (user.getLogin().equals("admin")) {
                adminExists = true;
                break;
            }
        }

        if (!adminExists) {
            userDatabase.addUser(mainAdmin);
        }


        Button zatwierdzenie = findViewById(R.id.logowanie);
        zatwierdzenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loginField = findViewById(R.id.main_login);
                EditText passwField = findViewById(R.id.main_passw);

                String enteredLogin = loginField.getText().toString().trim();
                String enteredPassword = passwField.getText().toString().trim();

                User loggedInUser = userDatabase.login(enteredLogin, enteredPassword);

                if (loggedInUser != null) {
                    if (loggedInUser.admin) {
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                        intent.putExtra("LOGIN", loggedInUser.getLogin());
                        intent.putExtra("PASSW", loggedInUser.getPassword());
                        if(enteredLogin.equals("admin") && enteredPassword.equals("admin")){
                            intent.putExtra("IsFirst", true);
                        }
                        else{
                            intent.putExtra("IsFirst", false);
                        }
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(MainActivity.this, UserActivity.class);
                        intent.putExtra("LOGIN", loggedInUser.getLogin());
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Invalid login or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}