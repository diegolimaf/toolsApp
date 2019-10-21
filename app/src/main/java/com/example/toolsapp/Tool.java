package com.example.toolsapp;

import org.w3c.dom.Text;

public class Tool {
    private String title;
    private String description;
    private String category;
    private int date;
    private int time;

    public Tool(String title, String description, String category){
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Tool(String title, String description, String category, int date, int time){
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;
    }
}
