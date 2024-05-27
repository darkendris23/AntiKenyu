package com.antique.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        EditText user = findViewById(R.id.loginUser);
        EditText pass = findViewById(R.id.loginPass);
        Button loginBTN = findViewById(R.id.btn_login);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUser = user.getText().toString().trim();
                String inputPass = pass.getText().toString().trim();

                if (inputUser.equals("user") && inputPass.equals("123456")) {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(SplashActivity.this,"Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
