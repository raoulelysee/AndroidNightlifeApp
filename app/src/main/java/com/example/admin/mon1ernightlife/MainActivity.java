package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.admin.mon1ernightlife.R.anim.zoom;
import static com.example.admin.mon1ernightlife.R.id.imageView1;

public class MainActivity extends AppCompatActivity {

    Button GoToLoginScreen;
    private Handler handler;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final int[] drawableArray = new int[]{R.drawable.club_nyc, R.drawable.damn, R.drawable.england3, R.drawable.paris_cafe_view};
        gettingBackground(drawableArray);

        //Creating a zoom animation on the background view
/*        final ImageView zoom = (ImageView) findViewById(imageView1);
        final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom.startAnimation(zoomAnimation);*/

        GoToLoginScreen = (Button)findViewById(R.id.buttonClient);
        GoToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToLoginScreen = new Intent(MainActivity.this,Login.class);
                startActivity(intentToLoginScreen);
            }
        });
    }

    private void gettingBackground(final int[] drawableArray){
        new Handler().postDelayed(new Runnable(){
            public void run(){
                if(count < drawableArray.length){
                   MainActivity.this.getWindow().
                            setBackgroundDrawableResource(drawableArray[count]);


                    count++;
                    gettingBackground(drawableArray);
                } else{
                    count = 0;
                }
            }
        }, 5000);

    }


}

