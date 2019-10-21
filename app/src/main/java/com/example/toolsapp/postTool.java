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
import android.widget.TextView;

import java.util.Date;

public class postTool extends AppCompatActivity {

    private RadioGroup radioGroup;

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

        if(TextUtils.isEmpty(title.getText()) || TextUtils.isEmpty(description.getText())){
            if (TextUtils.isEmpty(title.getText()))
                title.setError("You must choose a title for your ad!");
            else if (TextUtils.isEmpty(description.getText()))
                description.setError("The description is mandatory!");
        }else{
            String newTitle = title.getText().toString();
            String newDescription = description.getText().toString();
            Spinner dropdown = (Spinner)findViewById(R.id.category);
            String category = dropdown.getSelectedItem().toString();

            RadioButton rb1 = (RadioButton) findViewById(R.id.yes);
            boolean  checked = rb1.isChecked();

            if(checked && (TextUtils.isEmpty(time.getText()) || TextUtils.isEmpty(date.getText()))){
                if(TextUtils.isEmpty(date.getText()))
                    date.setError("Enter a date!");
                else if (TextUtils.isEmpty(time.getText()))
                    time.setError("Enter the time!");
            }
            else if(checked && !(TextUtils.isEmpty(time.getText()) || TextUtils.isEmpty(date.getText()))){
                String newDate = date.getText().toString();
                String newTime = time.getText().toString();
                Tool newTool = new Tool(newTitle, newDescription, category, newDate, newTime);
                System.out.println(newTool.getTitle() + "\n" + newTool.getDate());
            }

            else{
                Tool newTool = new Tool(newTitle, newDescription, category);
                System.out.println(newTool.getTitle() + "\n" + newTool.getDate());
            }
        }
    }
    public void checkButton(View myView){

        EditText date = (EditText)findViewById(R.id.date);
        EditText time = (EditText)findViewById(R.id.time);
        TextView textDate = findViewById(R.id.textDate);
        TextView textTime = findViewById(R.id.textTime);

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
                    textDate.setVisibility(View.VISIBLE);
                    textTime.setVisibility(View.VISIBLE);
                }
                    break;

            case R.id.no:
                if(checked){
                    date.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.INVISIBLE);
                    textDate.setVisibility(View.INVISIBLE);
                    textTime.setVisibility(View.INVISIBLE);
                }
                    break;
        }
    }



    public void submit(View myView){
        Intent post = new Intent(this, home.class);
        EditText title = (EditText)findViewById(R.id.title);
        EditText description = (EditText)findViewById(R.id.description);
        Spinner dropdown = (Spinner)findViewById(R.id.category);
        String category = dropdown.getSelectedItem().toString();
        EditText date = (EditText)findViewById(R.id.date);
        EditText time = (EditText)findViewById(R.id.time);

        boolean yesOrno = ((RadioButton)myView).isChecked();


        System.out.println(yesOrno);

        if(TextUtils.isEmpty(title.getText()) || TextUtils.isEmpty(description.getText()) ){
            if(TextUtils.isEmpty(title.getText()))
                title.setError("Mandatory");
            else if(TextUtils.isEmpty(description.getText()))
                description.setError("Username required");
            else if(yesOrno == true && TextUtils.isEmpty(date.getText())  || TextUtils.isEmpty(time.getText())){
                date.setError("Mandatory");
                time.setError("Mandatory");
            }
        }else{
            String newTitle = title.getText().toString();
            String newDescription = description.getText().toString();
            String category1 = category.toString();
            String newDate = date.getText().toString();
            String newTime = time.getText().toString();
            if (!yesOrno){
            Tool newtool = new Tool(newTitle, newDescription, category1);
                System.out.println(newtool.getTitle());}
         else {
                Tool newtool = new Tool(newTitle, newDescription, category1, newDate, newTime);
                System.out.println(newtool.getTitle());
            }
            startActivity(post);
        }
    }
}
