package controller;

import android.provider.ContactsContract;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.Calendar.Calendar;
import model.Dorm.DormObj;
import model.User.Dorm;
import model.User.RA;
import model.User.User;
import view.CalendarView;

/**
 * Created by Bill Xiong on 3/13/17.
 * Abstract class for managing all users- each subclass has own controller
 */

public abstract class UserController {

    private User user;
    private CalendarView calendarView;
    private DormController dormController;

    public UserController(CalendarView cv) {
        this.calendarView = cv;
        this.dormController = new DormController();
    }

    public User getOnCall(Dorm dorm, DataSnapshot snapshot) {
        User user = new RA();
        DormObj obj = new DormObj(dorm);
        obj = obj.read(DormObj.class, snapshot);
        Date today = obj.formatDate(DormObj.formatter.format(new Date()));
        return obj.getCalendarDates().get(today);
    }

    protected DormController getDormController() {
        return this.dormController;
    }

    protected CalendarView getCalendarView() {
        return this.calendarView;
    }
    protected User getUser() {
        return this.user;
    }

    protected void setUser(User user) {
        this.user = user;
    }

    public void populateCalendar(DataSnapshot dormSnap) {

        DormObj dorm = dormController.read(dormSnap);
        CalendarView cv = this.calendarView;
        GridView gridview = cv.getGridview();
        //TODO fix train wreck
        for (int i = 0; i < cv.getCalAdapter().getCount(); ++i) {
            Date key = dorm.formatDate((String) cv.getCalAdapter().getItem(i));
            if (dorm.getCalendarDates().containsKey(key)) {
                if (cv.getRAColors().containsKey(dorm.getCalendarDates().get(key).getUsername()) && (gridview.getChildAt(i) != null)) {
                    gridview.getChildAt(i).setBackgroundColor(cv.getRAColors().get(dorm.getCalendarDates().get(key).getUsername()));
                }
            }
        }
    }

    public abstract void addGridHandler(DataSnapshot snapshot);
}

