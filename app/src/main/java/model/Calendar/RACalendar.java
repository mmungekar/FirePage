package model.Calendar;

import android.support.annotation.Keep;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Convertable;
import model.Converted;
import model.User.RA;
import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 * ra calendar
 */

@Keep
public class RACalendar implements Calendar, Convertable {

    private String holder;

    //TODO make the value a Day object- right now we only need user information
    private Map<Date, User> dates;

    public RACalendar() {
        this.holder = "";
        this.dates = new HashMap<>();
    }

    public boolean addUser(Date d, User u) {
        return (u instanceof RA) && this.dates.put(d, u) == null;
    }

    public Map<Date, User> getDates() {
        return Collections.unmodifiableMap(this.dates);
    }


    public User getInfo(Date date) {
        return null;
    }

    public void switchUser(User a, User b, Date date) {

    }
    public String getHolder() {
        return this.holder;
    }

    public Converted convert() {
        return null;
    }
}
