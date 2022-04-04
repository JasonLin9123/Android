package com.example.a109590001_hw61;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String ShowToast = "Toppings:";
    String[] Toastdata = {"Chocolate syrup","Sprinkles","Crushed nuts","Cherries","Orio cookie crumbles"};
    int[] Check = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void onShowToast(View view) {
        ShowToast = "Toppings:";
        for(int i = 0;i<5;i++){
            if(Check[i] == 1){
                ShowToast = ShowToast + Toastdata[i] + " ";
            }
        }
        displayToast(ShowToast);
    }
    public void onCheckButtonClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox:
                if (checked)
                    Check[0] = 1;
                else
                    Check[0] = 0;
                break;
            case R.id.checkBox2:
                if (checked)
                    Check[1] = 1;
                else
                    Check[1] = 0;
                break;
            case R.id.checkBox3:
                if (checked)
                    Check[2] = 1;
                else
                    Check[2] = 0;
                break;
            case R.id.checkBox4:
                if (checked)
                    Check[3] = 1;
                else
                    Check[3] = 0;
                break;
            case R.id.checkBox5:
                if (checked)
                    Check[4] = 1;
                else
                    Check[4] = 0;
                break;
            default:
                break;
        }
    }
}