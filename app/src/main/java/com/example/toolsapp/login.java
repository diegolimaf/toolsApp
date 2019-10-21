package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signIn(View myView)
    {
        Intent signIN = new Intent(this, home.class);
        EditText username = (EditText) findViewById(R.id.username2);
        EditText password = (EditText) findViewById(R.id.password2);

        if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()))
        {
            if (TextUtils.isEmpty(username.getText()))
            {
                username.setError("Username cannot be empty.");
            }
            if (TextUtils.isEmpty(password.getText()))
            {
                password.setError("Password cannot be empty.");
            }
        } else
        {
            startActivity(signIN);
        }
    }
}
