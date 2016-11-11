package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
TextView GoToForgotPassword;
    Button SignIn;
    Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        GoToForgotPassword = (TextView)findViewById(R.id.forgotPassword);
        GoToForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToResetPassword = new Intent(Login.this,PasswordReset.class);
                startActivity(intentToResetPassword);
            }

        });

        SignIn = (Button)findViewById(R.id.buttonSignIn);
        SignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "You are login In" , Toast.LENGTH_SHORT ).show();

            }
        });

        SignUp = (Button)findViewById(R.id.buttonSignUp);
        SignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentToSignUp = new Intent(Login.this,SignUp.class);
                startActivity(intentToSignUp);

            }
        });
    }
}
