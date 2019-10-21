package com.example.toolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent newIntent = getIntent();
    }

    public void submit(View myView){
        Intent register = new Intent(this, postTool.class);
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
            else if(TextUtils.isEmpty(username.getText()))
                username.setError("Username required");
            else if(TextUtils.isEmpty(email.getText()))
                email.setError("You must enter an email!");
            else if(TextUtils.isEmpty(password.getText()))
                password.setError("Password required");
            else if(TextUtils.isEmpty(confPass.getText()))
                confPass.setError("You must confirm your password");
            else if(!password.getText().toString().equals(confPass.getText().toString()))
                confPass.setError("Password is not the same!");
        }else{
            String newName = name.getText().toString();
            String newUsername = username.getText().toString();
            String newEmail = email.getText().toString();
            String newPassword = password.getText().toString();

            User newUser = new User(newName, newUsername, newEmail, newPassword);
            register.putExtra("user", newUser);

            System.out.println(newUser.getEmail());
            startActivity(register);

        }
    }
}
