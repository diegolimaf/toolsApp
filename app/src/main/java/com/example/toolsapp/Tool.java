package com.example.toolsapp;

import org.w3c.dom.Text;

public class Tool {
    private String title;
    private String description;
    private int category;
    private String dateTime;

    public Tool(String title, String description, int category){
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Tool(String title, String description, int category, String dateTime){
        this.title = title;
        this.description = description;
        this.category = category;
        this.dateTime = dateTime;
    }
}
