package com.example.madl_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t;
    Button b1,b2,b3;
    int count=10;
    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener((View.OnClickListener) this);
        b2.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if(view==b1){
            if(count<50){
                t.setTextSize(count);
                count=count+5;
            }
            else{
                t.setTextSize(count);
                count=5;
            }
        }
        if(view==b2){
            if(flag==1){
                t.setTextColor(Color.GREEN);
                flag=2;
            }
            else if(flag==2){
                t.setTextColor(Color.BLUE);
                flag=3;
            }
            else{
                t.setTextColor(Color.RED);
                flag=1;
            }
        }
        if(view==b3){
            if(flag==1){
                t.setBackgroundColor(Color.GREEN);
                flag=2;
            }
            else if(flag==2){
                t.setBackgroundColor(Color.BLUE);
                flag=3;
            }
            else{
                t.setBackgroundColor(Color.RED);
                flag=1;
            }
        }
    }
}