package com.example.metronome.activity;

import android.graphics.Color;
import android.widget.Button;

public class MetronomeAnimation {

    private Button animation1, animation2, animation3, animation4;

    private boolean status = false;

    private boolean work = false;

    public void animation() {
        if (!status){
            work = false;
            animation4.setBackgroundColor(0xff353232);
            return;
        }

        work = true;

        try {
            animation4.setBackgroundColor(0xff353232);
            animation1.setBackgroundColor(Color.BLUE);
            Thread.sleep(1000);

            animation1.setBackgroundColor(0xff353232);
            animation2.setBackgroundColor(Color.BLUE);
            Thread.sleep(1000);

            animation2.setBackgroundColor(0xff353232);
            animation3.setBackgroundColor(Color.BLUE);
            Thread.sleep(1000);

            animation3.setBackgroundColor(0xff353232);
            animation4.setBackgroundColor(Color.BLUE);
            Thread.sleep(1000);

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

    public MetronomeAnimation(Button animation1, Button animation2, Button animation3, Button animation4) {
        this.animation1 = animation1;
        this.animation2 = animation2;
        this.animation3 = animation3;
        this.animation4 = animation4;
    }
}
