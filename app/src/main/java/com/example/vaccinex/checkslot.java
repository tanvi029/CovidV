package com.example.vaccinex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class checkslot extends AppCompatActivity {

    TextView a,b,c;
    Button btn;
    DatabaseReference reff;
    EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkslot);

        a=(TextView)findViewById(R.id.tvvaccine);
        b=(TextView)findViewById(R.id.tvlocation);
        c=(TextView)findViewById(R.id.tvtiming);
        et=(EditText)findViewById(R.id.etadhaar);

        btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nname=et.getText().toString();
                reff= FirebaseDatabase.getInstance().getReference().child("vaccine").child(nname);
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String vaccine=snapshot.child("vaccine").getValue().toString();
                        String location=snapshot.child("location").getValue().toString();
                        String timing=snapshot.child("timing").getValue().toString();

                        a.setText(vaccine);
                        b.setText(location);
                        c.setText(timing);
                    }

                    @Override
                    public void onCancelled(@NonNull  DatabaseError error) {

                    }
                });
            }
        });
    }
}