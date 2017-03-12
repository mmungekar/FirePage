package model.Privilege;

import java.util.Date;

import model.Calendar.Calendar;
import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manage updating calendar permissions
 */

public class UpdateCalendarPrivilege extends Privilege {


    private ReadCalendarPrivilege read;
    private Calendar calendar;

    public UpdateCalendarPrivilege(Calendar c) {
        super();
        this.read = new ReadCalendarPrivilege(c);
        this.calendar = c;
    }

    public ReadCalendarPrivilege getRead() {
        return this.read;
    }

    public void switchUser(User a, User b, Date date) {
        this.calendar.switchUser(a, b, date);
    }

    public void addUser(Date d, User a) {
        this.calendar.addUser(d, a);
    }

    public Calendar getCalendar() {
        return this.calendar;
    }
}
