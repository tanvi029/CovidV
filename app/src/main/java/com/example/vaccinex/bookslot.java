package com.example.vaccinex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bookslot extends AppCompatActivity {
    Button slot1,slot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookslot);
        slot2=findViewById(R.id.slot2);
        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookslot.this,slot2.class);
                startActivity(intent);
            }
        });

        slot1=findViewById(R.id.slot1);
        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookslot.this,slot1.class);
                startActivity(intent);
            }
        });
    }
}