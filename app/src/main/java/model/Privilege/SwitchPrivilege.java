package model.Privilege;

import java.util.Date;

import model.Calendar.Calendar;
import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 *
 */

public class SwitchPrivilege extends Privilege {

    private Calendar c;
    public SwitchPrivilege(Calendar c) {
        this.c = c;
    }

    public void switchUser(User a, User b, Date date) {
        this.c.switchUser(a, b, date);
    }
}
