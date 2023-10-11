package com.example.dapm_food;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageVieww;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // anh xa du lieu
        imageVieww =(ImageView) findViewById(R.id.imageView);
        textView =(TextView) findViewById(R.id.textView7);

        imageVieww.animate().alpha(0f).setDuration(0);
        textView.animate().alpha(0f).setDuration(0);

        imageVieww.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                textView.animate().alpha(1f).setDuration(800);
            }
        });

        //MainMenu directly after Mainactivity for Sign in
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainMenu.class);
                startActivity(intent);
                finish();

            }
        },3000);

    }
}