package com.example.inf04_quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.lang.reflect.Array;

public class pytanieModel {
    String[] pytanie;
    Context mContext;
    String[] odp_1;
    String[] odp_2;
    String[] odp_3;
    Integer poprawna_odp;

    public pytanieModel(String[] pytanie, String[] odp_1, String[] odp_2, String[] odp_3, Integer poprawna_odp) {
        mContext = mContext;
        this.pytanie = pytanie;
        this.odp_1 = odp_1;
        this.odp_2 = odp_2;
        this.odp_3 = odp_3;
        this.poprawna_odp = poprawna_odp;
    }

    public String[] getQuestion() {
        return pytanie;
    }
    public String[] getQuestions(){
        String[] mojepytania = {odp_1, odp_2, odp_3};
        return mojepytania;
    }
    public int correctId(){
        return poprawna_odp;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_pytanie, parent, false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.text_pytanie);
        RadioButton odp1 = (RadioButton) convertView.findViewById(R.id.radio_odp1);
        RadioButton odp2 = (RadioButton) convertView.findViewById(R.id.radio_odp2);
        RadioButton odp3 = (RadioButton) convertView.findViewById(R.id.radio_odp3);
        titleTextView.setText(pytanie[position]);
        odp1.setText(odp_1[position]);
        odp2.setText(odp_2[position]);
        odp3.setText(odp_3[position]);

        return convertView;
    }
}