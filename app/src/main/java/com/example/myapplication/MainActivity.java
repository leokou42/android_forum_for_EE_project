package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Context context;
    Button button, createbdbut;
    TextView idtextview, passtextview, alter, name, surname, marks;
    DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idtextview = findViewById(R.id.idspace);
        passtextview = findViewById((R.id.passspace));

        button = findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getname = idtextview.getText().toString();
                String getpass = passtextview.getText().toString();
                if (getname.equals("")){
                    Toast.makeText(MainActivity.this, "please input mail", Toast.LENGTH_LONG).show();
                }else if (!getname.equals("") && getpass.equals("")){
                    Toast.makeText(MainActivity.this, "please input pass", Toast.LENGTH_LONG).show();
                }else if (!getname.equals("") && !getpass.equals("")){
                    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                    Boolean trigger = false;
                    trigger = databaseHelper.checkvalid(getname,getpass);
                    if(trigger == false){
                        System.out.println("trigger is "+trigger+ " , getname = "+getname);
                        Toast.makeText(MainActivity.this, "Can't find !!!!",Toast.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this, MainMenu.class);
                        startActivity(intent);
                    }


                }
            }
        });

        createbdbut = findViewById(R.id.createdbbut);
        createbdbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateUser.class);
                startActivity(intent);
            }
        });



    }
}