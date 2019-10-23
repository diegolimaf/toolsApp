package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void addTool(View myView){
        Intent myIntent = new Intent(this, postTool.class);
        startActivity(myIntent);
    }
    public void homePage(View myView){
        Intent myIntent = new Intent(this, postTool.class);
        startActivity(myIntent);
    }
    public void myToolBox(View myView){
        Intent myIntent = new Intent(this, postTool.class);
        startActivity(myIntent);
    }
    public void messages(View myView){
        Intent myIntent = new Intent(this, postTool.class);
        startActivity(myIntent);
    }
    public void profile(View myView){
        Intent myIntent = new Intent(this, postTool.class);
        startActivity(myIntent);
    }
}
