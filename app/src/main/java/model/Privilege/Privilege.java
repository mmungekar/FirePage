package model.Privilege;

import com.google.firebase.database.Exclude;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for managing different privileges, such as viewing, switching, or changing
 * calendar
 */

public abstract class Privilege {

    public enum Privileges { READ_CALENDAR, SWITCH, UPDATE_CALENDAR, PAGE, NOTIFY }

    public Privilege() {

    }
}
