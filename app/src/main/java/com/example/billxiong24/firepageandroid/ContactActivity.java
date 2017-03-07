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

import java.util.ArrayList;
import java.util.List;

import model.User.Dorm;
import model.User.GR;
import model.User.RA;
import model.User.Resident;
import model.User.User;
import model.User.UserConverter;
import model.User.UserX;

/**
 * Created by Bill Xiong on 2/18/17.
 * main
 */

public class ContactActivity extends AppCompatActivity {
    private List<User> users = new ArrayList<>();
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
        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               for(DataSnapshot d : dataSnapshot.getChildren()) {
                   UserX userx = d.getValue(UserX.class);


                   System.out.println(userx.getName());
                   System.out.println(userx.getDorms());
                   System.out.println(userx.getDorms() == null);
               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new RA("bil", "billx","1234", "password","67676767");
                user.addToDormSet(Dorm.BROWN);
                user.addToDormSet(Dorm.BELLTOWER);
                UserX x = UserConverter.convertToUserX(user);
                DatabaseReference ref = childRef.child(x.getUsername());
                //DatabaseReference d = childRef.push();
                ref.setValue(x);
            }
        });

    }
}
