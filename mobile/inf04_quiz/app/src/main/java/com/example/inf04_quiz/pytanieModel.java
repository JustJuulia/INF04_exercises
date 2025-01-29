package com.example.inf04_quiz;

import android.content.Context;
import android.graphics.Color;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class pytanieModel extends ArrayAdapter<String[]> {
    public pytanieModel(Context context, int resource, List<String[]> pytania) {
        super(context, resource, pytania);
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
        final int poprawna_odp = Integer.parseInt(pytanie[4]);
        odp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton klikniety = (RadioButton) view;
                if (poprawna_odp == 1  && klikniety.getId() == R.id.radio_odp1) {
                    pytanie_linear.setBackgroundColor(Color.parseColor("#097969"));
                } else {
                    pytanie_linear.setBackgroundColor(Color.parseColor("#FF5733"));
                }
            }
        });

        odp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton klikniety = (RadioButton) view;
                if (poprawna_odp == 2 && klikniety.getId() == R.id.radio_odp2) {
                    pytanie_linear.setBackgroundColor(Color.parseColor("#097969"));
                } else {
                    pytanie_linear.setBackgroundColor(Color.parseColor("#FF5733"));
                }
            }
        });

        odp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton klikniety = (RadioButton) view;
                if (poprawna_odp == 3 && klikniety.getId() == R.id.radio_odp3) {
                    pytanie_linear.setBackgroundColor(Color.parseColor("#097969"));
                } else {
                    pytanie_linear.setBackgroundColor(Color.parseColor("#FF5733"));
                }
            }
        });

        return convertView;
    }
}
