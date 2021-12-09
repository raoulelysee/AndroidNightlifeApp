package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.admin.mon1ernightlife.SignUp.EXTRA_MESSAGE_USERNAME;

public class Welcome extends AppCompatActivity {

    TextView message;
    Button GoToDashboardScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        message =(TextView)findViewById(R.id.textViewReceiver);

        Intent intent = getIntent();
        String nameSigned = intent.getStringExtra(EXTRA_MESSAGE_USERNAME);

        message.setText(""+nameSigned);

        GoToDashboardScreen = (Button)findViewById(R.id.buttonNextPage);
        GoToDashboardScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent IntentToDasboardScreen = new Intent(Welcome.this,Dashboard.class);
                startActivity(IntentToDasboardScreen);
            }
        });
    }
}
