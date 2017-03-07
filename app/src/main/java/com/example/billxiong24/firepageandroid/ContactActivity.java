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
import java.util.Map;

import model.Privilege.Privilege;
import model.Privilege.SwitchPrivilege;
import model.User.Dorm;
import model.User.GR;
import model.User.Pojo.UserPojo;
import model.User.RA;
import model.User.RC;
import model.User.Resident;
import model.User.User;

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
        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d : dataSnapshot.getChildren()) {
//                    User u = d.getValue(RA.class);
//                    List<Object> list = (List) d.child("dorms").getValue();
//                    List<Object> subs = (List) d.child("subordinates").getValue();
//                    Map<String, Object> priv = (Map) d.child("privileges").getValue();
//
//                    for(String s : priv.keySet()) {
//                        System.out.println(priv.get(s));
//                    }
//                    System.out.println("-----");
//                    System.out.println(subs);
//                    for(Object a : subs) {
//                        System.out.println(a);
//                    }
//                    System.out.println(priv);
//                    System.out.println(list);
                }
//                UserPojo ra = dataSnapshot.getValue(UserPojo.class);
//                System.out.println(ra.getDorms());
//                System.out.println(ra.getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User gr = new GR("sarah");
                User u = new RA("William");
                u.addSubordinate(new Resident("bob"));
                u.addSubordinate(new Resident("drew"));
                u.addToDormSet(Dorm.BELLTOWER.toString());
                u.addToDormSet(Dorm.BROWN.toString());
                gr.addSubordinate(u);

                DatabaseReference d = childRef.push();
                d.setValue(gr);
            }
        });

    }
}
