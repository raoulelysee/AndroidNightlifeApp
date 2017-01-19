package com.example.admin.mon1ernightlife;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.regex.Pattern;

import static com.example.admin.mon1ernightlife.R.attr.icon;

public class SignUp extends AppCompatActivity {

    Button btnconfirmSignUp;
    EditText userName;
    EditText email;


    public final static String EXTRA_MESSAGE_USERNAME = "my username";
    public final static Pattern EMAIL_ADDRESS = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnconfirmSignUp = (Button) findViewById(R.id.buttonConfirmSignUp);

        btnconfirmSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawableAlertDialog = getResources().getDrawable(android.R.drawable.ic_dialog_alert);
                email = (EditText) findViewById(R.id.editTextEmailAddress);
                userName = (EditText) findViewById(R.id.editUserName);
                String userNameStringFormat = userName.getText().toString().trim();
                String emailStringFormat = email.getText().toString().trim();

                if (!isValidEmail(emailStringFormat)) {
                    email.setError("Invalid email address format", drawableAlertDialog);
                }

                // TODO
                //isEmailExist(emailStringFormat);
                //isUserNameExist(userNameStringFormat);

                Intent intentSendName = new Intent(SignUp.this, Welcome.class);
                intentSendName.putExtra(EXTRA_MESSAGE_USERNAME, userNameStringFormat);
                startActivity(intentSendName);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //TODO
    boolean isEmailExist(String email) {

        // return isEmailExistInDB();
        return true;
    }

    //TODO
    boolean isUserNameExist(String userName) {

        // return isUserNameExistInDB();
        return true;
    }

    boolean isValidEmail(String emailEntered) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;

        return pattern.matcher(emailEntered).matches();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("SignUp Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
