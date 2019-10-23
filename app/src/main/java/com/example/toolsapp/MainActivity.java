package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void register(View myView){

        Intent myIntent = new Intent(this, register.class);
        startActivity(myIntent);
    }

    public void login(View myView){

        Intent myIntent = new Intent(this, login.class);
        startActivity(myIntent);
    }
}
