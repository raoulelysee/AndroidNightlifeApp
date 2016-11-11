package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.admin.mon1ernightlife.R.id.imageView1;

public class MainActivity extends AppCompatActivity {

    Button GoToLoginScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating a zoom animation on the background view
        final ImageView zoom = (ImageView) findViewById(imageView1);
        final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom.startAnimation(zoomAnimation);

        GoToLoginScreen = (Button)findViewById(R.id.buttonClient);
        GoToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToLoginScreen = new Intent(MainActivity.this,Login.class);
                startActivity(intentToLoginScreen);
            }
        });
    }


}

