package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    Button btnconfirmSignUp;
    EditText firstName;
    EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = (EditText)findViewById(R.id.editTextFirstName);
        lastName = (EditText)findViewById(R.id.editTextLastName);


        String theFirstName = firstName.getText().toString();
        String theLastName = lastName.getText().toString();

        final String nameExtra = ""+theFirstName+" "+theLastName;

        btnconfirmSignUp = (Button)findViewById(R.id.buttonConfirmSignUp);
        btnconfirmSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentSendName = new Intent(SignUp.this, Welcome.class);
                intentSendName.putExtra("Name", nameExtra);
                startActivity(intentSendName);
            }
        });

    }
}
