package com.example.vaccinex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registerornot extends AppCompatActivity {

    Button bookslot,checkslot,userdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerornot);
        bookslot=findViewById(R.id.btnbookslot);
        checkslot=findViewById(R.id.btncheckslot);
        userdetails=findViewById(R.id.btnuserdetails);

        bookslot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerornot.this,bookslot.class);
                startActivity(intent);
            }
        });

        checkslot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerornot.this,checkslot.class);
                startActivity(intent);
            }
        });

        userdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerornot.this,userdetails.class );
                startActivity(intent);
            }
        });



    }
}