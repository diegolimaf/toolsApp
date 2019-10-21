package com.example.toolsapp;

import org.w3c.dom.Text;

public class Tool {
    private String title;
    private String description;
    private String category;
    private String date;
    private String time;

    public Tool(String title, String description, String category){
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Tool(String title, String description, String category, String date, String time){
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;
    }
}
