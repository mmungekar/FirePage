package model.Privilege;

import java.util.Date;

import model.Calendar.Calendar;
import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manages read calendar permissions
 */

public class ReadCalendarPrivilege extends Privilege {

    private Calendar calendar;

    public ReadCalendarPrivilege(Calendar c) {
        super();
        this.calendar = c;
    }

    public User getInfo(Date date) {
        return this.calendar.getInfo(date);
    }




}
