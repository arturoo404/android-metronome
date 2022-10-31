package com.example.metronome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.NumberPicker;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.metronome.activity.MetronomeAnimation;
import com.example.metronome.activity.TapActivity;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button animation1, animation2, animation3, animation4, metronomeAction;

    private MetronomeAnimation metronomeAnimation;

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberPickerInit();
        buttonInit();

        metronomeRun();
    }
    private void metronomeRun() {
        metronomeAction.setOnClickListener(v -> {
            if (metronomeAnimation == null){
                metronomeAnimation = new MetronomeAnimation(animation1, animation2, animation3, animation4);
            }

            if (!metronomeAnimation.isStatus() && !metronomeAnimation.isWork()){
                metronomeAnimation.setStatus(true);
                thread = new Thread(() -> metronomeAnimation.animation());
                thread.start();
                return;
            }

            metronomeAnimation.setStatus(false);
        });
    }


    private void numberPickerInit(){
        numberPicker = findViewById(R.id.tempo_picker);
        numberPicker.setMinValue(40);
        numberPicker.setMaxValue(250);
    }

    private void buttonInit(){
        animation1 = findViewById(R.id.animation_1);
        animation2 = findViewById(R.id.animation_2);
        animation3 = findViewById(R.id.animation_3);
        animation4 = findViewById(R.id.animation_4);
        metronomeAction = findViewById(R.id.start_button);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.tap_tempo_option) {
            Intent intent = new Intent(this, TapActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}