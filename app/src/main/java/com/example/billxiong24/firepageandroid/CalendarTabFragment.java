package com.example.billxiong24.firepageandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import controller.DormController;
import controller.RAController;
import view.CalendarView;


/**
 * Created by Ritler on 3/8/17.
 */

public class CalendarTabFragment extends Fragment {

    private RAController raController;
    private DormController dormController;

    public CalendarTabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.tab_calendar, container, false);

        final CalendarView cv = new CalendarView(getContext(), rootView);
        //hard coded for now
        raController = new RAController("billxion", cv);
        dormController = new DormController();

        //will go in controller
        raController.addSingleEventListener("", new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final DataSnapshot dormSnap = dataSnapshot.child("Dorms");
                dataSnapshot = dataSnapshot.child("RA");

                //TODO FIX dependencies
                raController.setRAInfo(dataSnapshot);
                raController.initRAs(dataSnapshot);
                dormController.setDormName(raController.getDorm());
                raController.addGridHandler(dormSnap);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;
    }
}
