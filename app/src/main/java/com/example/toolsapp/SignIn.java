package com.example.toolsapp;

import java.io.Serializable;

public class SignIn implements Serializable {

    private static String username;
    private static String password;

    private static volatile SignIn Singleton;

    public SignIn(String username, String password){

        if (Singleton != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }else{
            this.password = password;
            this.username = username;
        }
    }

    public static SignIn getInstance() {
        if (Singleton == null) { //if there is no instance available... create new one
            synchronized (SignIn.class) {
                if (Singleton == null) Singleton = new SignIn(username, password);
            }
        }

        return Singleton;
    }

    // Serializable operation.
    protected SignIn readResolve() {
        return getInstance();
    }
}
