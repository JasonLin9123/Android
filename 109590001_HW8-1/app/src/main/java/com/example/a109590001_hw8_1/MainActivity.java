package com.example.a109590001_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView print;
    private int level = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print = findViewById(R.id.battery);
        print.setImageLevel(level);
    }
    public void buttons_add(View view) {
        if(level < 6) {
            level++;
        }
        print.setImageLevel(level);
    }
    public void buttons_sub(View view) {
        if(level > 0) {
            level--;
        }
        print.setImageLevel(level);
    }
}