package com.jayway.klab.rxandroidlab.signup;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jayway.klab.rxandroidlab.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

/**
 * A login screen that offers login via email/password.
 */
public class SignUpActivity extends AppCompatActivity {

    @Bind(R.id.email)
    EditText emailEditText;

    @Bind(R.id.username)
    EditText userNameEditText;

    @Bind(R.id.password)
    EditText passwordEditText;

    @Bind(R.id.signup_button)
    Button signupButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setup();
    }

    @Override
    protected void onPause() {
        // Don't forget to unsubscribe

        super.onPause();
    }

    private void setup() {
        /*
            LAB GOES HERE!

            Make all three text fields to observables. Generate events leading up to the "Sign Up"
            button being enabled when all three fields contain valid values:

            * Email must contain an @ sign and a .
            * Username must be at least of length 5 and can't contain any spaces.
            * Password must be at least 5 characters long.

            If they go from valid to invalid, the button should go back to a disabled state.
         */
    }

    @OnClick(R.id.signup_button)
    public void signUp() {
        Toast.makeText(this, "You signed up! Congratulations!", Toast.LENGTH_LONG).show();
    }
}

