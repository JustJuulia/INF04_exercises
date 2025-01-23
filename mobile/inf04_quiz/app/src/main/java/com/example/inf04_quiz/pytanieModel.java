package com.example.inf04_quiz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class pytanieModel extends ArrayAdapter<String> {

    String[] pytanie;
    String[] odp_1;
    String[] odp_2;
    String[] odp_3;
    Integer[] poprawna_odp;

    public pytanieModel(Context context, int resource, String[] pytanie, String[] odp_1, String[] odp_2, String[] odp_3, Integer[] poprawna_odp) {
        super(context, resource, pytanie);
        this.pytanie = pytanie;
        this.odp_1 = odp_1;
        this.odp_2 = odp_2;
        this.odp_3 = odp_3;
        this.poprawna_odp = poprawna_odp;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_pytanie, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.text_pytanie);
        RadioButton odp1 = convertView.findViewById(R.id.radio_odp1);
        RadioButton odp2 = convertView.findViewById(R.id.radio_odp2);
        RadioButton odp3 = convertView.findViewById(R.id.radio_odp3);

        titleTextView.setText(pytanie[position]);
        odp1.setText(odp_1[position]);
        odp2.setText(odp_2[position]);
        odp3.setText(odp_3[position]);
        LinearLayout pytanie_linear = convertView.findViewById(R.id.pytanie_id);
        odp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((poprawna_odp[position] + 1) == 1){
                    pytanie_linear.setBackgroundColor(Color.parseColor("#097969"));
                }
                else{
                    pytanie_linear.setBackgroundColor(Color.parseColor("#FF5733"));
                }
            }
        });
        odp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        odp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return convertView;
    }
}
