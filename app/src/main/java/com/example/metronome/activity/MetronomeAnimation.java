package com.example.metronome.activity;

import android.graphics.Color;
import android.widget.Button;

public class MetronomeAnimation {

    private Button animation1, animation2, animation3, animation4;

    private boolean status = false;

    private boolean work = false;

    private long tempo;

    public void animation() {

        work = true;

        try {
            animation4.setBackgroundColor(0xff353232);
            if (!status){
                work = false;
                return;
            }
            animation1.setBackgroundColor(Color.BLUE);
            Thread.sleep(tempo);

            animation1.setBackgroundColor(0xff353232);
            if (!status){
                work = false;
                return;
            }
            animation2.setBackgroundColor(Color.BLUE);
            Thread.sleep(tempo);

            animation2.setBackgroundColor(0xff353232);
            if (!status){
                work = false;
                return;
            }
            animation3.setBackgroundColor(Color.BLUE);
            Thread.sleep(tempo);

            animation3.setBackgroundColor(0xff353232);
            if (!status){
                work = false;
                return;
            }
            animation4.setBackgroundColor(Color.BLUE);
            Thread.sleep(tempo);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        animation();
    }

    public boolean isWork() {
        return work;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public MetronomeAnimation(Button animation1, Button animation2, Button animation3, Button animation4) {
        this.animation1 = animation1;
        this.animation2 = animation2;
        this.animation3 = animation3;
        this.animation4 = animation4;
    }
}
