package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.admin.mon1ernightlife.Friends.FriendsList;
import com.example.admin.mon1ernightlife.Maps.Map;
import com.example.admin.mon1ernightlife.ProfileUserMenu.Profile;

public class Dashboard extends AppCompatActivity  implements View.OnClickListener{

    ImageButton profileButton;
    ImageButton arrowButton;
    ImageButton friendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );

        profileButton = (ImageButton) findViewById( R.id.buttonProfile );
        profileButton.setOnClickListener(this );

        arrowButton = (ImageButton) findViewById( R.id.buttonArrow );
        arrowButton.setOnClickListener(this );

        friendButton = (ImageButton)findViewById(R.id.buttonFriend);
        friendButton.setOnClickListener(this);

    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.buttonProfile:
                Intent intentToProfileScreen = new Intent( Dashboard.this, Profile.class );
                startActivity( intentToProfileScreen );
                break;

            case R.id.buttonArrow:
                Intent intentToMapScreen = new Intent( Dashboard.this, Map.class );
                startActivity( intentToMapScreen );
                break;

            case R.id.buttonFriend:
                Intent intentToFriendScreen = new Intent( Dashboard.this, FriendsList.class );
                startActivity( intentToFriendScreen );
                break;
            default:
                break;
        }
    }

}



