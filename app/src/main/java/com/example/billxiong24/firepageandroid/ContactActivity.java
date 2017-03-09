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
import model.User.RA;
import model.User.Resident;
import model.User.User;
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
                   System.out.println("counting child" + d.getChildrenCount());
                   UserX userx = d.getValue(UserX.class);
                   System.out.println(userx.getName());
                   System.out.println("these are dorms" + userx.getDorms());
                   System.out.println("these are priuv" + userx.getPrivileges());
                   System.out.println(userx.getDorms() == null);
                   //TODO avoid casting this
                   User converted = userx.convertBack(RA.class, dataSnapshot);
                   System.out.println("PRAY THIS WORKSSS" + converted.getName());
                   System.out.println("PRAY THIS WORKSSS" + converted.getPhone_number());
                   System.out.println("PRAY THIS WORKSSS" + converted.getUsername());
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
                User user = new RA("bil", "billxion","1234", "password","67676767");
                user.addToDormSet(Dorm.BROWN);
                user.addToDormSet(Dorm.BELLTOWER);
                user.addToDormSet(Dorm.BASSET);
                user.insert();
                User res = new Resident("ritwik head", "ritler", "5436435", "pass", "8475687");
                System.out.println(res.getClass().getSimpleName());
                res.addToDormSet(Dorm.RANDOLPH);
                res.insert();

                //DatabaseReference d = childRef.push();
            }
        });

    }
}
