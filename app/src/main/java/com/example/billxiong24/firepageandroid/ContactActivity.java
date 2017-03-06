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

import model.User.Dorm;
import model.User.Pojo.UserPojo;

/**
 * Created by Bill Xiong on 2/18/17.
 * main
 */

public class ContactActivity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference childRef = mRootRef.child("RA");
    private Button b;
    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.activity_contact);
    }

    protected void onStart() {
        super.onStart();
        childRef.child("1234").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserPojo ra = dataSnapshot.getValue(UserPojo.class);
                System.out.println(ra.getDorms());
                System.out.println(ra.getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserPojo user = new UserPojo("Bill"+Math.random());
                user.getDorms().add(Dorm.BASSET.toString());
                DatabaseReference d = childRef.push();
                d.setValue(user);


                System.out.println("hello");
            }
        });

    }
}
