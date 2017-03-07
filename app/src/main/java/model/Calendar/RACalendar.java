package model.Calendar;

import android.support.annotation.Keep;

import java.util.Date;

import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 * ra calendar
 */

@Keep
public class RACalendar implements Calendar {

    private String holder;
    public RACalendar() {
        this.holder = "";
    }
    public void addUser(User u) {

    }

    public User getInfo(Date date) {
        return null;
    }

    public void switchUser(User a, User b, Date date) {

    }
    public String getHolder() {
        return this.holder;
    }
}
