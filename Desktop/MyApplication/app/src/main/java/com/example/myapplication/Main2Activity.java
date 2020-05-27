package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    private SnowCanvas canvas;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d("Thread", "Mainactivity_2_Thread:"+Thread.currentThread().getId());
        new logd().logd(this,"kkk");

        test();
        test("1");
        test("2","3");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Thread", "thread_Thread:"+Thread.currentThread().getId());
            }
        });
        thread.start();

        canvas = findViewById(R.id.canvas);
        canvas.post(new Runnable() {
            @Override
            public void run() {
                canvas.init();
            }
        });
    }

    public void test(String... x){
        Boolean b = x.length == 0 ;
        Log.d("test", b?"null":x.length+"");

    }
}
