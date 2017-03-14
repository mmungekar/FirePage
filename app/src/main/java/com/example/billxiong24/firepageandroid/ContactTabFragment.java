package com.example.billxiong24.firepageandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import model.Dorm.DormObj;


/**
 * Created by Ritler on 3/8/17.
 */

public class ContactTabFragment extends Fragment {
    View rootView;
    Spinner spinner;
    ArrayList<String> list= new ArrayList<String>();
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference childRef = mRootRef.child("RA");
    private DatabaseReference dormRef = mRootRef.child("Dorms");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final HashMap<String, String> dorms = new HashMap<>();
        dormRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("hello wolrdd");
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    DormObj obj = new DormObj();
                    obj = obj.read(DormObj.class, d);
                    list.add(obj.getName().toString());
                    dorms.put(obj.getName().toString(), obj.getPhone_number());
                    System.out.println("pleas work");
                }


                setDormList();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        rootView = inflater.inflate(R.layout.tab_contact, container, false);
        spinner = (Spinner) rootView.findViewById(R.id.spinner);


        return rootView;
    }
    public void setDormList(){
        /*for(String d: sampleArray){
            System.out.println(d);
        }*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_list_item_1, list.toArray(new String[list.size()]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }



}
