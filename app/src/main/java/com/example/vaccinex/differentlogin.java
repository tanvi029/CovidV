package com.example.vaccinex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class differentlogin extends AppCompatActivity {
    Button login_email,login_phone,login_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_differentlogin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_differentlogin);
        login_email=(Button)findViewById(R.id.loginemail);
        login_phone=(Button)findViewById(R.id.loginphone);
        login_admin=(Button)findViewById(R.id.loginadmin);
        login_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(differentlogin.this,login.class);
                startActivity(intent);
            }
        });
        login_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(differentlogin.this,phonelogin.class);
                startActivity(intent);
            }
        });

        login_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(differentlogin.this,admindashboard.class);
                startActivity(intent);
            }
        });

    }
}