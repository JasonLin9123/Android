package com.example.a109590001_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showDonut(View view) {
        Intent intent = new Intent(this, donut_circle.class);
        startActivity(intent);
    }
    public void showFroyo(View view) {
        Intent intent = new Intent(this, froyo_circle.class);
        startActivity(intent);
    }
    public void showIcecream(View view) {
        Intent intent = new Intent(this, icecream_circle.class);
        startActivity(intent);
    }
}