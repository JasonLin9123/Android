package com.example.a109590001_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        if (savedInstanceState != null) {
            Integer count = savedInstanceState.getInt("count");
            if (mShowCount != null) {
                mCount = count;
                mShowCount.setText(Integer.toString(mCount));
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",mCount);
    }
    public void countUp(View view) {
        mCount++;
        mShowCount.setText(Integer.toString(mCount));

    }

}