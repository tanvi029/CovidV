package com.example.vaccinex;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class userdetails extends AppCompatActivity {


TextView a,b,c,d,e,f,g;
Button btn;
DatabaseReference reff;
EditText et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        a=(TextView)findViewById(R.id.tvname);
        b=(TextView)findViewById(R.id.tvemail);
        c=(TextView)findViewById(R.id.tvage);
        d=(TextView)findViewById(R.id.tvnumber);
        e=(TextView)findViewById(R.id.tvgender);
        f=(TextView)findViewById(R.id.tvadhaar);
        g=(TextView)findViewById(R.id.tvaddress);
        et=(EditText)findViewById(R.id.etname);


        btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nname=et.getText().toString();
                reff=FirebaseDatabase.getInstance().getReference().child("users").child(nname);

                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String name=snapshot.child("name").getValue().toString();
                        String email=snapshot.child("email").getValue().toString();
                        String phonenumber=snapshot.child("phonenumber").getValue().toString();
                        String age=snapshot.child("age").getValue().toString();
                        String gender=snapshot.child("gender").getValue().toString();
                        String adhaar=snapshot.child("adhaar").getValue().toString();
                        String address=snapshot.child("address").getValue().toString();
                        a.setText(name);
                        b.setText(email);
                        c.setText(age);
                        d.setText(phonenumber);
                        e.setText(gender);
                        f.setText(adhaar);
                        g.setText(address);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}