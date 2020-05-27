package com.example.myapplication;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View;


public class View_animator extends View {
    Paint paint = new Paint();
    int i = 0;
    int j = 0;
    boolean black = false;
    boolean white = true;
    Time time = new Time();

    public View_animator(Context context  , AttributeSet attributeSet) {
        super(context,attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        j = j+1;

        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawArc(new RectF(0,0,200,200),0,j,true,paint);

        if(j == 360){
            j = -360;
        }


        postInvalidate();



        super.onDraw(canvas);
    }

    void setApple(){

    }
}
