package com.example.vaccinex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    Button signupbtn,go,home,forgot;
    TextInputLayout signupemail,signuppass;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        home=findViewById(R.id.home);
        go=findViewById(R.id.go);
        signupemail=findViewById(R.id.username);
        signuppass=findViewById(R.id.password);
        fAuth=FirebaseAuth.getInstance();
        signupbtn=findViewById(R.id.signup_screen);
        forgot=findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,forgotpassword.class);
                startActivity(intent);
            }
        });


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=signupemail.getEditText().getText().toString().trim();
                String password=signuppass.getEditText().getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    signupemail.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    signuppass.setError("Password is required");
                    return;
                }
                if(password.length()<6){
                    signuppass.setError(" password must be equal to or greater than 6 charecters.");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login.this,"Logged in Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),registerornot.class));
                        }else{
                            Toast.makeText(login.this,"Error! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });


    }
}
