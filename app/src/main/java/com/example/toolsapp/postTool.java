package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

        EditText title = (EditText)findViewById(R.id.title);
        EditText description = (EditText)findViewById(R.id.description);
        EditText date = (EditText)findViewById(R.id.date);
        EditText time = (EditText)findViewById(R.id.time);

        if(TextUtils.isEmpty(title.getText()) || TextUtils.isEmpty(description.getText()) ||
                TextUtils.isEmpty(date.getText()) || TextUtils.isEmpty(time.getText())){
            if (TextUtils.isEmpty(title.getText()))
                title.setError("Mandatory");
            else if (TextUtils.isEmpty(description.getText()))
                description.setError("Username required");
        }

        Intent myIntent = new Intent(this, home.class);
        startActivity(myIntent);

    }
    public void checkButton(View myView){

        EditText date = (EditText)findViewById(R.id.date);
        EditText time = (EditText)findViewById(R.id.time);

        //require to import the RadioButton class
        RadioButton rb1 = (RadioButton) findViewById(R.id.yes);
        RadioButton rb2 = (RadioButton) findViewById(R.id.no);

        //is the current radio button now checked?
        boolean  checked = ((RadioButton)myView).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch(myView.getId()){

            case R.id.yes:
                if(checked){
                    date.setVisibility(View.VISIBLE);
                    time.setVisibility(View.VISIBLE);
                }
                    break;

            case R.id.no:
                if(checked){
                    date.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.INVISIBLE);
                }
                    break;
        }
    }
}
