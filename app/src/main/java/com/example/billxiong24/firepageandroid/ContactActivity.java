package com.example.billxiong24.firepageandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import model.User.Resident;
import model.User.User;

/**
 * Created by billxiong24 on 2/18/17.
 */

public class ContactActivity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference childRef = mRootRef.child("dorms");
    private Button b;
    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.activity_contact);
    }

    protected void onStart() {
        super.onStart();
        childRef.child("Blackwell").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.child("12292016").getValue(String.class);
                System.out.println(text + " firebase text");
                System.out.println("Changined");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new Resident("Bill");
                System.out.println("hello");
            }
        });

    }
}
