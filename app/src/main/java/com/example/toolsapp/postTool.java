package com.example.toolsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class postTool extends AppCompatActivity {

    RadioGroup radioGroup;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_tool);
        Spinner dropdown = (Spinner) findViewById(R.id.category);
        String[] items = new String[]{"General", "Plumbing", "Gardening", "Farming", "Industrial"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        ImageView image = (ImageView)findViewById(R.id.previewImage);

        //encode image to base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.missingicon);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

        //decode base64 string to image
        imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        image.setImageBitmap(decodedImage);
    }

    public void post(View myView) {
        final Intent homeIntent = new Intent(this, home.class);
        final Intent postAgain = new Intent(this, postTool.class);

        EditText title = findViewById(R.id.title);
        EditText description = (EditText) findViewById(R.id.description);
        EditText date = (EditText) findViewById(R.id.date);
        EditText time = (EditText) findViewById(R.id.time);

        if (TextUtils.isEmpty(title.getText()) || TextUtils.isEmpty(description.getText())) {
            if (TextUtils.isEmpty(title.getText()))
                title.setError("You must choose a title for your ad!");
            if (TextUtils.isEmpty(description.getText()))
                description.setError("The description is mandatory!");
        } else {
            String newTitle = title.getText().toString();
            String newDescription = description.getText().toString();
            Spinner dropdown = (Spinner) findViewById(R.id.category);
            String category = dropdown.getSelectedItem().toString();

            RadioButton rb1 = (RadioButton) findViewById(R.id.yes);
            boolean checked = rb1.isChecked();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Tollshare");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(postAgain);
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(homeIntent);
                }
            });

            if (checked && (TextUtils.isEmpty(time.getText()) || TextUtils.isEmpty(date.getText()))) {
                if (TextUtils.isEmpty(date.getText()))
                    date.setError("Enter a date!");
                if (TextUtils.isEmpty(time.getText()))
                    time.setError("Enter the time!");
            } else if (checked && !(TextUtils.isEmpty(time.getText()) || TextUtils.isEmpty(date.getText()))) {
                String newDate = date.getText().toString();
                String newTime = time.getText().toString();
                Tool newTool = new Tool(newTitle, newDescription, category, newDate, newTime);
                alert.setMessage("You have posted the tool: " + newTool.getTitle() + "\nWould you like to post another tool?");
                alert.create().show();
            } else {
                Tool newTool = new Tool(newTitle, newDescription, category);
                alert.setMessage("You have posted the tool: " + newTool.getTitle() + "\nWould you like to post another tool?");
                alert.create().show();
            }
        }
    }

    public void checkButton(View myView) {

        EditText date = (EditText) findViewById(R.id.date);
        EditText time = (EditText) findViewById(R.id.time);
        TextView textDate = findViewById(R.id.textDate);
        TextView textTime = findViewById(R.id.textTime);

        boolean checked = ((RadioButton) myView).isChecked();

        switch (myView.getId()) {

            case R.id.yes:
                if (checked) {
                    date.setVisibility(View.VISIBLE);
                    time.setVisibility(View.VISIBLE);
                    textDate.setVisibility(View.VISIBLE);
                    textTime.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.no:
                if (checked) {
                    date.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.INVISIBLE);
                    textDate.setVisibility(View.INVISIBLE);
                    textTime.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }


}