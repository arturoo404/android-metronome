package com.example.metronome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.NumberPicker;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.metronome.activity.TapActivity;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberPickerInit();
    }


    private void numberPickerInit(){
        numberPicker = findViewById(R.id.tempo_picker);
        numberPicker.setMinValue(40);
        numberPicker.setMaxValue(250);
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