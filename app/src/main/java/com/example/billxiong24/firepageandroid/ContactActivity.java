package com.example.billxiong24.firepageandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Dorm.DormObj;
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
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference childRef = mRootRef.child("RA");
    private DatabaseReference dormRef = mRootRef.child("Dorms");
    private Button b, b2;
    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.activity_contact);
    }

    protected void onStart() {
        super.onStart();


        dormRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("HELLO WORLD PLEASE WORK");
                for(DataSnapshot data : dataSnapshot.getChildren()) {

                    DormObj obj = new DormObj();
                    obj = obj.read(DormObj.class, data);
                    System.out.println(obj.getName() + "NAME");
                    System.out.println(obj.getCalendarDates());

                    for(Date d : obj.getCalendarDates().keySet()) {
                        System.out.println(d);
                        System.out.println(obj.getCalendarDates().get(d).getDorms());
                        System.out.println(obj.getCalendarDates().get(d).getPhone_number());
                    }

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("CHILD REFHELLO WORLD PLEASE WORK");
                System.out.println(dataSnapshot.child("billxion").exists() + "CHECk user name exists");
                User used = new RA();
                used = used.read(RA.class, dataSnapshot, "billxion");
                System.out.println("CHECKING" + used.getDorms());


                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    User user = new RA();
                    User converted = user.read(RA.class, d);
                    System.out.println("dorms exists" + d.child("dorms").exists());



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
                res.addToDormSet(Dorm.RANDOLPH);
                res.insert();

                user.update("phone_number", "6666666");
                user.update("password", "hellopass");
                //DatabaseReference d = childRef.push();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //childRef.child("billxion").child("dorms").child("3").setValue(Dorm.GILES.toString());
                DormObj dorm = new DormObj(Dorm.RANDOLPH);
                User user = new RA("bil", "billxiong","1234", "password","67676767");
                user.addToDormSet(Dorm.BROWN);
                user.addToDormSet(Dorm.BELLTOWER);
                user.addToDormSet(Dorm.BASSET);
                dorm.addCalendarDate(new Date(), user);
                dorm.insert();

                //dormRef.child(Dorm.RANDOLPH.toString()).child("dates").child("2017-03-12").setValue("reeee");

            }
        });

    }
}
