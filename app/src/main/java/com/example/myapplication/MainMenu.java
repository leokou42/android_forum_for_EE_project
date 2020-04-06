package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {
    private ArrayList<String> mName = new ArrayList<>();
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        // TODO: 4/6/2020 add number into mName as ArrayList, but the type of array is String,
    }
}
