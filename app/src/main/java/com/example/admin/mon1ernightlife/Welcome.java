package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.jar.Attributes;

import static com.example.admin.mon1ernightlife.SignUp.EXTRA_MESSAGE_USERNAME;

public class Welcome extends AppCompatActivity {

    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        message =(TextView)findViewById(R.id.textViewReceiver);

        Intent intent = getIntent();
        String nameSigned = intent.getStringExtra(EXTRA_MESSAGE_USERNAME);

        message.setText(""+nameSigned);
    }
}
