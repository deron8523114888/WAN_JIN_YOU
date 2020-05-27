package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.snowing.Snow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnowCanvas extends View {

    private Paint paint;
    int Snow_count = 50;
    ArrayList<Snow> snows = new ArrayList<>();;
    Random random = new Random();


    public SnowCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(paint == null) {
            paint = new Paint();
        }

        paint.setColor(Color.WHITE);
        paint.setTextSize(60);

        for (Snow snow : snows) {

            Log.d("Snow", "onDraw: ");
            canvas.drawText("雪",snow.getX(),snow.getY(),paint);

            Log.d("Thread", "SnowCanvas_Thread:"+Thread.currentThread().getId());
        }

    }

    public void init(){
        float Width = getWidth();
        float Height = getHeight();
        for(int i = 0 ; i < Snow_count ; i++){
            int x = random.nextInt((int) Width);
            int y = random.nextInt((int) Height);
            snows.add(new Snow(x,y));
        }
        Log.v("Snow",Width+","+Height);

        Log.d("Thread", "inti_Thread:"+Thread.currentThread().getId());
    }

}
