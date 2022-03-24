package com.example.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        SampleCanvas sc=new SampleCanvas(this);
        setContentView(sc);

    }

    private class SampleCanvas extends View {
        public SampleCanvas(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setTextSize(80);

            paint.setColor(Color.YELLOW);

            canvas.drawPaint(paint);

            paint.setColor(Color.BLUE);

            canvas.drawText("Circle",375,200,paint);
            canvas.drawCircle(500,500,250,paint);

            canvas.drawText("Rectangle",920,200,paint);
            canvas.drawRect(1000,250,1200,750,paint);

            canvas.drawText("Square",375,900,paint);
            canvas.drawRect(250,1000,750,1500,paint);

            paint.setStrokeWidth(5);
            canvas.drawText("Line",1020,900,paint);
            canvas.drawLine(1100,1000,1100,1500,paint);


        }
    }
}