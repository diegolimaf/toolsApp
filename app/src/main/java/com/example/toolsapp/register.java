package com.example.toolsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent newIntent = getIntent();
    }

    public void submit(View myView){
        final Intent register = new Intent(this, login.class);
        EditText name = (EditText)findViewById(R.id.name);
        EditText username = (EditText)findViewById(R.id.username);
        EditText email = (EditText)findViewById(R.id.email);
        EditText password = (EditText)findViewById(R.id.password);
        EditText confPass = (EditText)findViewById(R.id.confPassword);

        if(TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(username.getText()) ||
                TextUtils.isEmpty(email.getText()) || TextUtils.isEmpty(password.getText()) ||
                !password.getText().toString().equals(confPass.getText().toString())){
            if(TextUtils.isEmpty(name.getText()))
                name.setError("Mandatory");
            if(TextUtils.isEmpty(username.getText()))
                username.setError("Username required");
            if(TextUtils.isEmpty(email.getText()))
                email.setError("You must enter an email!");
            if(TextUtils.isEmpty(password.getText()))
                password.setError("Password required");
            if(TextUtils.isEmpty(confPass.getText()))
                confPass.setError("You must confirm your password");
            if(!password.getText().toString().equals(confPass.getText().toString()))
                confPass.setError("Password is not the same!");
        }else{
            String newName = name.getText().toString();
            String newUsername = username.getText().toString();
            String newEmail = email.getText().toString();
            String newPassword = password.getText().toString();

            User newUser = new User(newName, newUsername, newEmail, newPassword);
            register.putExtra("user", newUser);

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Tollshare");
            alert.setMessage("User created with success. \nYou can login now!");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(register);
                }
            });
            alert.create().show();
        }
    }
}
