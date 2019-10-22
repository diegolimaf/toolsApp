package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Successfully_registered extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully_registered);

        Intent newIntent = getIntent();
        TextView greeting = (TextView)findViewById(R.id.greeting);
        String username = newIntent.getStringExtra("username");
        greeting.setText("Congratulations " +username+" !!! You have successfully registered.");
    }
    public void goToHomePage(View myView)
    {
        Intent goToHomePage = new Intent(this,home.class);
        startActivity(goToHomePage);

    }
}
