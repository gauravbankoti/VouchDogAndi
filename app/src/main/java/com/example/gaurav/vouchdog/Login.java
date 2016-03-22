package com.example.gaurav.vouchdog;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


                new CountDownTimer(3000, 1000) {
                    public void onFinish() {
                        Intent startActivity = new Intent(Login.this, SignUp.class);
                        startActivity(startActivity);
                        finish();
                    }

                    public void onTick(long millisUntilFinished) {
                    }

                }.start();

    }
}
