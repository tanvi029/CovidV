package com.example.vaccinex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registeration extends AppCompatActivity {

    Button registerbtn,home;
    TextInputLayout sname,semailid,sage,sphonenumber,saddress,sadhaar,sgender;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sname=findViewById(R.id.name);
        semailid=findViewById(R.id.email);
        sage=findViewById(R.id.age);
        sphonenumber=findViewById(R.id.phonenumber);
        saddress=findViewById(R.id.address);
        sadhaar=findViewById(R.id.adhaar);
        sgender=findViewById(R.id.gender);
        fAuth=FirebaseAuth.getInstance();





        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(registeration.this,differentlogin.class);
                startActivity(intent);

            }
        });





        registerbtn=(Button)findViewById(R.id.register);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users");



                String name=sname.getEditText().getText().toString();
                String email=semailid.getEditText().getText().toString();
                String age=sage.getEditText().getText().toString();
                String phonenumber=sphonenumber.getEditText().getText().toString();
                if(phonenumber.length()!=10) {
                    sphonenumber.setError("phone number should be of 10 charecters.");
                    return;
                }
                String address=saddress.getEditText().getText().toString();
                String adhaar=sadhaar.getEditText().getText().toString();
                if(adhaar.length()!=12) {
                    sadhaar.setError("Adhaar number should be of 12 charecters.");
                    return;
                }
                String gender=sgender.getEditText().getText().toString();
                UserHelperClass helperClass=new UserHelperClass(name,email,age,phonenumber,address,adhaar,gender);
               reference.child(name).setValue(helperClass);


               Intent intent=new Intent(registeration.this,login.class);
               startActivity(intent);






            }
        });




    }
}