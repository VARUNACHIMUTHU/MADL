package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText e1,e2,e3;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.editTextNumber);
        e2 = (EditText) findViewById(R.id.editTextNumber2);
        e3 = (EditText) findViewById(R.id.editTextNumber6);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener((View.OnClickListener) this);
        b2.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
        b4.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        String s1=e1.getText().toString();
        String s2=e2.getText().toString();
        if(view==b1){
            int rs=Integer.parseInt(s1)+Integer.parseInt(s2);
            e3.setText(Integer.toString(rs));
        }
        else if(view==b2){
            int rs=Integer.parseInt(s1)-Integer.parseInt(s2);
            e3.setText(Integer.toString(rs));
        }
        else if(view==b3){
            int rs=Integer.parseInt(s1)*Integer.parseInt(s2);
            e3.setText(Integer.toString(rs));
        }
        else{
            float rs=Float.parseFloat(s1)/Float.parseFloat(s2);
            e3.setText(Float.toString(rs));
        }
    }
}