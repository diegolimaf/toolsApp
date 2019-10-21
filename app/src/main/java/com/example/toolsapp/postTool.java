package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class postTool extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_tool);
        Spinner dropdown = (Spinner)findViewById(R.id.category);
        String[] items = new String[]{"General", "Plumbing", "Gardening", "Farming", "Industrial"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

    }
    public void post(View myView){
        Intent myIntent = new Intent(this, home.class);
        startActivity(myIntent);

    }
    public void checkButton(View myView){
        EditText date = (EditText)findViewById(R.id.date);
        EditText time = (EditText)findViewById(R.id.time);

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        if(radioId == 2131296431){
            date.setVisibility(View.VISIBLE);
            time.setVisibility(View.VISIBLE);
        }else{
            date.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
        }
        System.out.println(radioId);
    }
}
