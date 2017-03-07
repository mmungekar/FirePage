package model.Privilege;

import java.util.Date;

import model.Calendar.Calendar;
import model.Calendar.RACalendar;
import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 *
 */

public class SwitchPrivilege extends Privilege {

    private RACalendar c;

    public SwitchPrivilege() {

    }
    public SwitchPrivilege(RACalendar c) {
        this.c = c;
    }

    public void switchUser(User a, User b, Date date) {
        this.c.switchUser(a, b, date);
    }

    public RACalendar getCalendar() {
        return this.c;
    }
}
