package com.example.inf04_adminlog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.admin_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView all_people = findViewById(R.id.mojalista);
        String login = getIntent().getStringExtra("LOGIN");
        AllUsers userDatabase = AllUsers.getInstance();
        List<User> userList = userDatabase.getAllUsers();
        UserListAdapter adapter = new UserListAdapter(this, userList, login);
        all_people.setAdapter(adapter);
        String userLogin = getIntent().getStringExtra("USER_LOGIN");
        String userPassword = getIntent().getStringExtra("USER_PASSWORD");
        String userName = getIntent().getStringExtra("USER_NAME");
        String userSurname = getIntent().getStringExtra("USER_SURNAME");
        boolean isAdmin = getIntent().getBooleanExtra("USER_ADMIN", false);
        EditText im = findViewById(R.id.a_imie);
        EditText nz = findViewById(R.id.a_nazwisko);
        EditText lg = findViewById(R.id.a_login);
        EditText ps = findViewById(R.id.a_passw);
        CheckBox ca = findViewById(R.id.checkBox);
        im.setText(userName);
        nz.setText(userSurname);
        lg.setText(userLogin);
        ps.setText(userPassword);
        ca.setChecked(isAdmin);




    }
}
