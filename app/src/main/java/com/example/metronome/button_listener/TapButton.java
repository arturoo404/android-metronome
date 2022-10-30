package com.example.metronome.button_listener;

import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class TapButton implements View.OnClickListener {

    private final TextView textView;

    private static Date date;

    private static long lastDiff;
    public TapButton(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        initDate();
        Date dateToCompere = new Date();
        long tempo = 0;

        long diff = (dateToCompere.getTime() - date.getTime()) / 10;

        if (diff != 0){
            diff = (diff + lastDiff) / 2;
            tempo = (long) 6000 / diff;
        }

        lastDiff = diff;
        date = dateToCompere;
        textView.setText(String.valueOf(tempo));
    }

    private void initDate() {
        if (date == null){
            date = new Date();
        }
    }
}
