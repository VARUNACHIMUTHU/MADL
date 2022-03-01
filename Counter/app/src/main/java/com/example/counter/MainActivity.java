package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1 , t2;
    int count = 0;
    Button b1 , b2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view == b1){
            count = count + 1;
            t2.setText("" + count);
            Toast T = Toast.makeText(this , "Increased by 1" , Toast.LENGTH_SHORT);
            T.show();
        }
        if(view == b2){
            count = count - 1;
            t2.setText("" + count);
            Toast T = Toast.makeText(this , "Decreased by 1" , Toast.LENGTH_SHORT);
            T.show();
        }
    }
}