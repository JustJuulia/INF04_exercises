package com.example.inf04_adminlog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        Button dodaj = findViewById(R.id.Dodaj);
        Button usun = findViewById(R.id.Usun);
        Button wyjdz = findViewById(R.id.Wyjdz);
        Button zmien = findViewById(R.id.Zmien);
        CheckBox ca = findViewById(R.id.checkBox);
        EditText im = findViewById(R.id.a_imie);
        EditText nz = findViewById(R.id.a_nazwisko);
        EditText lg = findViewById(R.id.a_login);
        EditText ps = findViewById(R.id.a_passw);
        AllUsers userDatabase = AllUsers.getInstance();
        List<User> userList = userDatabase.getAllUsers();

        UserListAdapter adapter = new UserListAdapter(this, userList, login);
        all_people.setAdapter(adapter);
        String userLogin = getIntent().getStringExtra("USER_LOGIN");
        String userPassword = getIntent().getStringExtra("USER_PASSWORD");
        String userName = getIntent().getStringExtra("USER_NAME");
        String userSurname = getIntent().getStringExtra("USER_SURNAME");
        boolean isAdmin = getIntent().getBooleanExtra("USER_ADMIN", false);
        boolean isFirst = getIntent().getBooleanExtra("IsFirst", false);
        if(isFirst){
            dodaj.setEnabled(false);
            usun.setEnabled(false);
            wyjdz.setEnabled(false);
            all_people.setEnabled(false);
            zmien.setEnabled(false);
            ps.setText("admin");
            TextWatcher adm_tw = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    zmien.setEnabled(true);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }

            };
            ps.addTextChangedListener(adm_tw);
        }
        else {
            if(login.equals("admin")){
                ca.setEnabled(true);
                dodaj.setEnabled(true);
                usun.setEnabled(true);
                wyjdz.setEnabled(true);
                all_people.setEnabled(true);
                zmien.setEnabled(true);
                im.setText(userName);
                nz.setText(userSurname);
                lg.setText(userLogin);
                ps.setText(userPassword);
            }
            else {
                dodaj.setEnabled(true);
                usun.setEnabled(true);
                wyjdz.setEnabled(true);
                all_people.setEnabled(true);
                zmien.setEnabled(true);
                im.setText(userName);
                nz.setText(userSurname);
                lg.setText(userLogin);
                ps.setText(userPassword);
                ca.setEnabled(false);
            }
        }

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllUsers userDatabase = AllUsers.getInstance();
                User add_new = new User(lg.getText().toString(), ps.getText().toString(), im.getText().toString(), nz.getText().toString(),ca.isChecked());
                userDatabase.addUser(add_new);
                finish();
                startActivity(getIntent());
            }
        });
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllUsers userDatabase = AllUsers.getInstance();
                userDatabase.delteUser(lg.getText().toString());
                finish();
                startActivity(getIntent());
            }
        });
        wyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        zmien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFirst){
                    AllUsers userDatabase = AllUsers.getInstance();
                    userDatabase.changeTheUser(ps.getText().toString());
                    Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    AllUsers userDatabase = AllUsers.getInstance();
                    userDatabase.changeUser(lg.getText().toString(), ps.getText().toString(), im.getText().toString(), nz.getText().toString(), ca.isChecked());
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }
}
