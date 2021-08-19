package com.example.vaccinex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class slot2 extends AppCompatActivity {

    EditText vaccine,location,timing,number;
    Button btn;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        vaccine=(EditText) findViewById(R.id.tvvaccine);
        location=(EditText) findViewById(R.id.tvlocation);
        timing=(EditText) findViewById(R.id.tvtiming);
        number=(EditText)findViewById(R.id.tvnumber);

        btn=(Button)findViewById(R.id.button2);
        fAuth=FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("vaccine");

                String vac=vaccine.getText().toString();
                String loc=location.getText().toString();
                String num=number.getText().toString();
                String tim=timing.getText().toString();

                VaccineHelperClass helperClass=new VaccineHelperClass(vac,loc,tim,num);


                reference.child(num).setValue(helperClass);


            }
        });

    }
}