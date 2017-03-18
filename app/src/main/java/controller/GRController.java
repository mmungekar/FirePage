package controller;

import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;

import view.CalendarView;

/**
 * Created by Bill Xiong on 3/17/17.
 * Controller for GR
 */

public class GRController extends UserController {

    public GRController(CalendarView cv) {
        super(cv);
    }

    public void addGridHandler(DataSnapshot snapshot) {

    }
}
