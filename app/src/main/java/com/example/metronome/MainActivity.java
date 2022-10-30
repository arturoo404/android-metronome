package com.example.metronome;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.metronome.button_listener.TapButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tapInit();
    }

    private void tapInit(){
        Button button = findViewById(R.id.tap_button);
        button.setOnClickListener(new TapButton(findViewById(R.id.tempo)));
    }
}