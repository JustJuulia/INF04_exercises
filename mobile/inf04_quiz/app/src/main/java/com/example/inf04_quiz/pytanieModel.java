package com.example.inf04_quiz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class pytanieModel extends ArrayAdapter<String[]> {
    private int[] selectedAnswers;
    private TextView wynikTextView;
    private Button resetButton;
    public pytanieModel(Context context, int resource, List<String[]> pytania, TextView wynikTextView) {
        super(context, resource, pytania);
        this.wynikTextView = wynikTextView;
        selectedAnswers = new int[pytania.size()];
        Arrays.fill(selectedAnswers, -1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_pytanie, parent, false);
        }

        String[] pytanie = getItem(position);
        TextView titleTextView = convertView.findViewById(R.id.text_pytanie);
        RadioButton odp1 = convertView.findViewById(R.id.radio_odp1);
        RadioButton odp2 = convertView.findViewById(R.id.radio_odp2);
        RadioButton odp3 = convertView.findViewById(R.id.radio_odp3);
        LinearLayout pytanie_linear = convertView.findViewById(R.id.pytanie_id);

        titleTextView.setText(pytanie[0]);
        odp1.setText(pytanie[1]);
        odp2.setText(pytanie[2]);
        odp3.setText(pytanie[3]);

        odp1.setChecked(selectedAnswers[position] == 1);
        odp2.setChecked(selectedAnswers[position] == 2);
        odp3.setChecked(selectedAnswers[position] == 3);

        if (selectedAnswers[position] == Integer.parseInt(pytanie[4])) {
            pytanie_linear.setBackgroundColor(Color.parseColor("#097969"));
        } else if (selectedAnswers[position] != -1) {
            pytanie_linear.setBackgroundColor(Color.parseColor("#FF5733"));
        } else {
            pytanie_linear.setBackgroundColor(Color.TRANSPARENT);
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = -1;
                if (view.getId() == R.id.radio_odp1) {
                    selected = 1;
                } else if (view.getId() == R.id.radio_odp2) {
                    selected = 2;
                } else if (view.getId() == R.id.radio_odp3) {
                    selected = 3;
                }
                selectedAnswers[position] = selected;
                notifyDataSetChanged();
                aktualizujWynik();
            }
        };

        odp1.setOnClickListener(listener);
        odp2.setOnClickListener(listener);
        odp3.setOnClickListener(listener);

        return convertView;
    }
    private void aktualizujWynik() {
        int liczbaPoprawnych = getLiczbaPoprawnychOdpowiedzi();
        wynikTextView.setText(liczbaPoprawnych + "/10");
    }
    public int getLiczbaPoprawnychOdpowiedzi() {
        int liczbaPoprawnych = 0;
        for (int i = 0; i < getCount(); i++) {
            String[] pytanie = getItem(i);
            if (selectedAnswers[i] == Integer.parseInt(pytanie[4])) {
                liczbaPoprawnych++;
            }
        }
        return liczbaPoprawnych;
    }

    public void resetujOdpowiedzi() {
        Arrays.fill(selectedAnswers, -1);
        notifyDataSetChanged();
        aktualizujWynik();
    }
}