package com.example.inf04_quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class wynikModel extends ArrayAdapter<Integer> {
    private int wynik;
    private TextView wynikTextView;

    public wynikModel(Context context, int resource, List<Integer> wyniki) {
        super(context, resource, wyniki);
        this.wynik = wyniki.get(0);
    }

    public void aktualizujWynik(int nowyWynik) {
        this.wynik = nowyWynik;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_podsumowanie, parent, false);
        }
        wynikTextView = convertView.findViewById(R.id.text_wynik);
        wynikTextView.setText("Wynik: " + wynik + "/10");

        return convertView;
    }

    public int getWynik() {
        return wynik;
    }
}
