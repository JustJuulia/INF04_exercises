package com.example.inf04_adminlog;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<User> users;
    private LayoutInflater inflater;
    private String loggedInUserLogin;

    public UserListAdapter(Context context, List<User> users, String loggedInUserLogin) {
        this.context = context;
        this.users = users;
        this.loggedInUserLogin = loggedInUserLogin;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.added_user, parent, false);
        }

        User user = users.get(position);

        TextView dane = convertView.findViewById(R.id.imie_nazw);
        dane.setText("Imie: " + user.name + " Nazwisko: " + user.surname);
        if (user.getLogin().equals(loggedInUserLogin)) {
            convertView.setBackgroundColor(Color.RED);

        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AdminActivity.class);
            intent.putExtra("USER_LOGIN", user.getLogin());
            intent.putExtra("USER_PASSWORD", user.getPassword());
            intent.putExtra("USER_NAME", user.name);
            intent.putExtra("USER_SURNAME", user.surname);
            intent.putExtra("USER_ADMIN", user.admin);
            context.startActivity(intent);
        });
        return convertView;
    }
}
