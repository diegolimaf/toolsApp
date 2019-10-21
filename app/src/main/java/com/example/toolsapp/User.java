package com.example.toolsapp;

import java.io.Serializable;

public class User implements Serializable
{
    private String name;
    private String username;
    private String email;
    private String password;

    public User(String name, String username, String email, String password)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return this.username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
