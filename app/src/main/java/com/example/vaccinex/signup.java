package com.example.vaccinex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    Button signupbtn,login;
    TextInputLayout  signupemail, signuppass, signupconpass;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signupemail=findViewById(R.id.email);
        signuppass=findViewById(R.id.password);
        signupconpass=findViewById(R.id.confirmpassword);
        signupbtn=(Button)findViewById(R.id.signupbtn);
        login=findViewById(R.id.login);

        fAuth=FirebaseAuth.getInstance();

        signupbtn.setOnClickListener(new View.OnClickListener() {
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

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),registeration.class));
                        }
                        else{
                            Toast.makeText(signup.this,"Error! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}