package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateUser extends AppCompatActivity {

    Button okbut;
    TextView createuser, createpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        okbut = findViewById(R.id.okbut);
        okbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createuser = findViewById(R.id.createuser);
                createpass = findViewById(R.id.createpass);

                DatabaseHelper db = new DatabaseHelper(CreateUser.this);
                boolean test = false;
                test = db.insertdata(createuser.getText().toString(), createpass.getText().toString());
                if (test = false){
                    Toast.makeText(CreateUser.this, "wrong!!!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(CreateUser.this, "OKKKKK!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}