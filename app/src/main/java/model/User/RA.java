package model.User;

import com.google.firebase.database.Exclude;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import model.Calendar.RACalendar;
import model.Privilege.Privilege;
import model.Privilege.PrivilegeFactory;
import model.Privilege.SwitchPrivilege;


/**
 * Created by Bill Xiong on 3/3/17.
 * Defines RA abilities, privileges, etc.
 */

public class RA extends User {


    public RA() {
        super();
    }
    public RA(String name) {
        super(name);
        this.addPrivilege(Privilege.Privileges.SWITCH);
        this.addPrivilege(Privilege.Privileges.READ_CALENDAR);
        this.addPrivilege(Privilege.Privileges.PAGE);
    }

    /**
     * A getter to return a map of privileges
     * @return a map of privileges owned by a specific user
     */


    /**
     * get user's name
     * @return a string containing user's name
     */
    @Exclude
    public boolean insert() {
        return false;
    }

    @Exclude
    public boolean addSubordinate(User u) {
        return (u instanceof Resident) && this.addToSubSet(u);
    }

}
