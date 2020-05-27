package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float down_x;
    GridView gridView ;
    String[] gridview_text = new String[]{"水果行星","海盜尋寶","嫦娥后羿","魔龍之戰","全面開動","夜夜牲歌",
                                            "煉獄鬼跡","大聖紀元","孤群勾搭","拳力遊戲","紅帽雙煞","鼠來寶",
                                            "鐵杵神醫","暴雪獵手","金蓮三缺一","忍喵物語","仙境狂想曲","熊太的壽司",
                                            "水果行星","維京統樂會","原始蛋疼人","惡魔血域","復活之夜","吉普賽之魅",
                                            "忠義食堂","天狗季","武狀元","王牌大鏢客"};

    int[] drawables = new int[]{R.drawable.image,R.drawable.rank_3,R.drawable.rank_4,R.drawable.rank_5,
            R.drawable.rank_6,R.drawable.rank_7,R.drawable.rank_8,R.drawable.rank_9};
    ImageView bodyimage;

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Window_Width = findViewById(R.id.Window_Width);
        TextView Window_Height = findViewById(R.id.Window_Height);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Log.d("phone", "widthPixels:"+displayMetrics.widthPixels);
        Log.d("phone", "heightPixels:"+displayMetrics.heightPixels);
        Log.d("phone", "density:"+displayMetrics.density);
        Log.d("phone", "densityDpi:"+displayMetrics.densityDpi);
        Log.d("phone", "scaledDensity:"+displayMetrics.scaledDensity);
        Log.d("phone", "xdpi:"+displayMetrics.xdpi);
        Log.d("phone", "ydpi:"+displayMetrics.ydpi);

        Window_Width.setText("寬:"+displayMetrics.widthPixels);
        Window_Height.setText("高:"+displayMetrics.heightPixels);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , aabbbcc.class);
                startActivity(intent);
            }
        });


        Log.d("Thread", "Mainactivity_Thread:"+Thread.currentThread().getId());

        Intent intent = new Intent(MainActivity.this,Bottom_navigation.class);
        startActivity(intent);

        gridView = findViewById(R.id.Gridview);
        adapter baseAdapter = new adapter();
        gridView.setAdapter(baseAdapter);

        TextView Marquee = findViewById(R.id.Marquee);
        Marquee.setSelected(true);

        bodyimage = findViewById(R.id.body_image);
        bodyimage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    down_x = event.getX();
                    Log.d("motion", down_x+"按下");
                }else if(event.getAction() == MotionEvent.ACTION_UP){

                    Log.d("motion", event.getX()+"彈起");
                    if(event.getX() > down_x ){
                        tranX_animation(-1000, bodyimage.getDrawable().getCurrent().getConstantState());
                    }else if(event.getX() < down_x){
                        tranX_animation(1000, bodyimage.getDrawable().getCurrent().getConstantState());
                    }
                }else if (event.getAction() == MotionEvent.ACTION_MOVE){
                    Log.d("motion", event.getX()+"移動");
                }


                return true;
            }
        });

    }


    private void tranX_animation(int start, final Drawable.ConstantState drawable){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(bodyimage,"translationX",start, 0);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                if (drawable == getResources().getDrawable(R.drawable.rank_2).getConstantState()) {
                    bodyimage.setImageDrawable(getDrawable(R.drawable.rank_3));
                } else if (drawable == getResources().getDrawable(R.drawable.rank_3).getConstantState()) {
                    bodyimage.setImageDrawable(getDrawable(R.drawable.rank_2));
                }
            }
            public void onAnimationEnd(Animator animation) { }
            public void onAnimationCancel(Animator animation) { }
            public void onAnimationRepeat(Animator animation) { }
        });
        objectAnimator.start();
    }

    private class adapter extends BaseAdapter {


        @Override
        public int getCount() {
            return gridview_text.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            @SuppressLint({"ViewHolder", "InflateParams"})
            View view = getLayoutInflater().inflate(R.layout.main_gridview,null);

            TextView textView = view.findViewById(R.id.textview);
            ImageView imageView = view.findViewById(R.id.imageView);

            textView.setText(gridview_text[position]);
            imageView.setImageResource(drawables[0]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,gridview_text[position],Toast.LENGTH_SHORT).show();
                }
            });



            return view.findViewById(R.id.laout);


        }


    }


}
