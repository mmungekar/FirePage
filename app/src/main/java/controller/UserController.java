package controller;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.Dorm.DormObj;
import model.User.Dorm;
import model.User.RA;
import model.User.User;

/**
 * Created by Bill Xiong on 3/13/17.
 * Abstract class for managing all users- each subclass has own controller
 */

public abstract class UserController {

    public User getOnCall(Dorm dorm, DataSnapshot snapshot) {
        User user = new RA();
        DormObj obj = new DormObj(dorm);
        obj = obj.read(DormObj.class, snapshot);
        Date today = obj.formatDate(DormObj.formatter.format(new Date()));
        return obj.getCalendarDates().get(today);
    }

}

