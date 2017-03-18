package controller;

import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;

import model.User.Resident;
import view.CalendarView;

/**
 * Created by Bill Xiong on 3/16/17.
 * Controller for residents
 */

public class ResidentController extends UserController {

    public ResidentController(CalendarView cv) {
        super(cv);
    }

    public void addGridHandler(DataSnapshot snapshot) {

    }
}
